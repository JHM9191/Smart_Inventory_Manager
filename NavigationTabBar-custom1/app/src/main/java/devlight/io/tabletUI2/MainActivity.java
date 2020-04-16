package devlight.io.tabletUI2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import msg.Msg;

// 오류수정 : Maps new 로 생성 안해주었음 -> 수정. //

public class MainActivity extends Activity implements View.OnClickListener {

    TextView txt_PadName,txt_Date,txt_Temperature,txt_myStatus;
   CircleProgressBar progressBar;
    Date tDate;
    String TAG = "===";

    // Network
    ServerSocket serverSocket;
    int port = 9999;
    ServerReadyThread serverReadyThread;
    public static HashMap<String, ObjectOutputStream> maps;
    public static HashMap<String, String> ids;

    // ServerReadyThread variables
    boolean aflag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        showCurrentTime();
        serverReadyThread = new ServerReadyThread();
        serverReadyThread.start();



    }

    public void showCurrentTime(){
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                long now = System.currentTimeMillis();
                tDate = new Date(now);
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                String getTime = simpleDate.format(tDate);

                txt_Date = findViewById(R.id.txt_Date);
                txt_Date.setText("현재시간\n"+getTime);
            }
        };
        Runnable currentTime = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(30000);
                        Log.d(TAG,"CurrentTime Refreshed");

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(1);
                }
            }
        };
        Thread threadTime = new Thread(currentTime);
        threadTime.start();
    }

    private void initUI() {
        final View viewProgress = findViewById(R.id.viewProgress);
        viewProgress.setOnClickListener(this);
//        final View btnHorizontalCoordinatorNtb = findViewById(R.id.btn_horizontal_coordinator_ntb);
//        btnHorizontalCoordinatorNtb.setOnClickListener(this);
//        final View btnTopHorizontalNtb = findViewById(R.id.btn_horizontal_top_ntb);
//        btnTopHorizontalNtb.setOnClickListener(this);
        final View btnVerticalNtb = findViewById(R.id.btn_vertical_ntb);
        btnVerticalNtb.setOnClickListener(this);



        txt_PadName = findViewById(R.id.txt_PadName);
        txt_Temperature = findViewById(R.id.txt_Temperature);

        txt_myStatus = findViewById(R.id.txt_myStatus);

        // 최초 현재시간 찍기 //
        long now = System.currentTimeMillis();
        tDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String getTime = simpleDate.format(tDate);

        txt_Date = findViewById(R.id.txt_Date);
        txt_Date.setText("현재시간\n"+getTime);
        // 현재시간 찍기 끝 , Refresh 는 30초마다 실행//

        // webServer 연결은 나중에 //
       // new ConnectThread(sip, sport, "pad").start();

        progressBar = findViewById(R.id.days_graph);
        progressBar.setMax(100);
        progressBar.setProgress(90);
        //progressBar.setProgressFormatter((progress, max) -> { final String DEFAULT_PATTERN = "%d퍼센트"; return String.format(DEFAULT_PATTERN, (int) ((float) progress / (float) max * 100)); });


//        final View btnSamplesNtb = findViewById(R.id.btn_samples_ntb);
//        btnSamplesNtb.setOnClickListener(this);
        maps = new HashMap<>();
        ids = new HashMap<>();
    }

    class ServerReadyThread extends Thread {

        public ServerReadyThread() {

            try {
                serverSocket = new ServerSocket(port);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (aflag) {
                Socket socket = null;
                Log.d(TAG, "Server Ready");

                try {
                    socket = serverSocket.accept();
                    Log.d(TAG, "socket = serverSocket.accept()");
                    Log.d(TAG, "socket.isConnected() : " + socket.isConnected());
                    new ReceiverThread(socket).start();
                    Log.d(TAG, "new ReceiverThread(socket).start()");


                } catch (IOException e) {

                    e.printStackTrace();

                    Log.d(TAG, "client disconnected");
                    maps.remove(socket.getInetAddress().toString());
                    ids.remove(socket.getInetAddress().toString());
                    displayData(new Msg("pad", null, null));

                }
            }
        }
    }
    class ReceiverThread extends Thread {

        InputStream is;
        ObjectInputStream ois;

        OutputStream os;
        ObjectOutputStream oos;

        Socket socket;


        public ReceiverThread(Socket socket) {
            this.socket = socket;
            try {
                this.is = socket.getInputStream();
                this.ois = new ObjectInputStream(is);
                this.os = socket.getOutputStream();
                this.oos = new ObjectOutputStream(os);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.d(TAG, "Client IP : " + socket.getInetAddress().getHostAddress().toString());
            if(oos != null) {
                try {
                    maps.put(socket.getInetAddress().getHostAddress().toString(), oos);
                    Msg msg = (Msg) ois.readObject();
                    Log.d(TAG, "msg.getId() : " + msg.getId());
                    ids.put(socket.getInetAddress().getHostAddress().toString(), msg.getId());
                    Log.d(TAG, "Client TXT : " + msg.getTxt());
                    Log.d(TAG, "Client TID : " + msg.getTid());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        @Override
        public void run() {
            while (ois != null) {
                Msg msg = null;
                try {
                    msg = (Msg) ois.readObject();

                    Log.d(TAG, "ReceiverThread run() ois!=null");
                    displayData(msg);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
//                    e.printStackTrace();
                    Log.d(TAG, "client disconnected");
                    maps.remove(socket.getInetAddress().toString());
                    ids.remove(socket.getInetAddress().toString());
                    displayData(new Msg("pad", null, null));

                    if (ois != null) {
                        try {
                            ois.close();
                            return;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }
        }
    }

    private void displayData(final Msg msg) {
        String id = msg.getId();
        String txt = msg.getTxt();
        //double tmp = Double.parseDouble(txt);



        Log.d(TAG, "id: "+id + "txt" + txt);
        if(txt!=null && txt !="") {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txt_myStatus.setText(id);
                    progressBar.setProgress(Integer.parseInt(txt));
                }
            });
        }
    }

    @Override
    public void onClick(final View v) {
        ViewCompat.animate(v)
                .setDuration(200)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setInterpolator(new CycleInterpolator())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(final View view) {

                    }

                    @Override
                    public void onAnimationEnd(final View view) {

                        switch (v.getId()) {
//                            case R.id.viewProgress:
//                               startActivity(
//                                       new Intent(MainActivity.this, TopHorizontalNtbActivity.class)
//                               );
//                               break;
                            case R.id.viewProgress:
                                startActivity(
                                        new Intent(MainActivity.this, ProgressActivity.class)
                                );
                                break;
//                            case R.id.btn_horizontal_top_ntb:
//                                startActivity(
//                                        new Intent(MainActivity.this, TopHorizontalNtbActivity.class)
//                                );
//                                break;
//                            case R.id.btn_horizontal_coordinator_ntb:
//                                startActivity(
//                                        new Intent(MainActivity.this, HorizontalCoordinatorNtbActivity.class)
//                                );
//                                break;
                            case R.id.btn_vertical_ntb:
                                startActivity(
                                        new Intent(MainActivity.this, VerticalNtbActivity.class)
                                );
                                break;
//                            case R.id.btn_samples_ntb:
//                                startActivity(
//                                        new Intent(MainActivity.this, SamplesNtbActivity.class)
//                                );
//                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onAnimationCancel(final View view) {

                    }
                })
                .withLayer()
                .start();
    }


    private class CycleInterpolator implements android.view.animation.Interpolator {

        private final float mCycles = 0.5f;

        @Override
        public float getInterpolation(final float input) {
            return (float) Math.sin(2.0f * mCycles * Math.PI * input);
        }
    }
}
