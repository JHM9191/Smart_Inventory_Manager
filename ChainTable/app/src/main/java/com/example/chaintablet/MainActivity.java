package com.example.chaintablet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.example.chaintablet.network.DeliverStateCheckRunnable;
import com.example.chaintablet.network.SendDeliverCompleteRunnable;
import com.example.chaintablet.vo.ContainerVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import msg.Msg;


// 오류수정 : Maps new 로 생성 안해주었음 -> 수정. //

public class MainActivity extends Activity implements View.OnClickListener {

    TextView txt_PadName, txt_Date, txt_deliverStatus, txt_myStatus;
    CircleProgressBar progressBar;
    Date tDate;
    String TAG = "===";

    public static ArrayList<ContainerVO> conList = new ArrayList<>();
    public static String userID = "user0001";
//    public static String orderID = "";
//    public static String chainID = "chainID_1000001";
//    public static String chainName = "카페 TOP(역삼 2호점)";
    public static String orderID = "orderID_1000040";
    public static String chainID = "chainID_1000000";
    public static String chainName = "카페 TOP(역삼 1호점)";


    public static String deliverStatusFromServer = "no response";


    // Network
    ServerSocket serverSocket;
    int port = 9999;
    ServerReadyThread serverReadyThread;
    public static HashMap<String, ObjectOutputStream> maps;
    public static HashMap<String, String> ids;
    public static HashMap<String, ArrayList<ContainerVO>> contianerInfo;


    // ServerReadyThread variables
    boolean aflag = true;


    // Client
    TextView tv_server_state;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        showCurrentTime();
        serverReadyThread = new ServerReadyThread();
        serverReadyThread.start();


        FirebaseMessaging.getInstance().subscribeToTopic("chainTablet").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                String msg = "Subscribing to topic \"chainTablet\" completed";
                if (!task.isSuccessful()) {
                    msg = "Subscription fail";
                }

                Log.d(TAG, msg);
            }
        });


    }

    public void showCurrentTime() {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                long now = System.currentTimeMillis();
                tDate = new Date(now);
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                String getTime = simpleDate.format(tDate);

                txt_Date = findViewById(R.id.txt_date);
                txt_Date.setText("현재시간\n" + getTime);
            }
        };
        Runnable currentTime = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(30000);
                        Log.d(TAG, "CurrentTime Refreshed");

                    } catch (Exception e) {
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


        txt_myStatus = findViewById(R.id.txt_myStatus);

        txt_deliverStatus = findViewById(R.id.txt_deliverStatus);


        final View btn_deliverStateCheck = findViewById(R.id.btn_deliverStateCheck);
        btn_deliverStateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread th = new Thread(new DeliverStateCheckRunnable(chainID));
                th.start();

                try {
                    th.join();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txt_deliverStatus.setText("배송상태: " + deliverStatusFromServer);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        final View btn_deliverComplete = findViewById(R.id.btn_deliverComplete);
        btn_deliverComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread th = new Thread(new SendDeliverCompleteRunnable(orderID));
                th.start();
                try {
                    th.join();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txt_deliverStatus.setText("배송상태: " + deliverStatusFromServer);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });


        // 최초 현재시간 찍기 //
        long now = System.currentTimeMillis();
        tDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String getTime = simpleDate.format(tDate);

        txt_Date = findViewById(R.id.txt_date);
        txt_Date.setText("현재시간\n" + getTime);
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


        //------ Client UI ---//
//        tv_server_state = findViewById(R.id.tv_server_state);
//        frameLayout = findViewById(R.id.frameLayout_main);
//        frameLayout.setVisibility(View.VISIBLE);

//        new Thread(new ConnectThread(serverIP, serverPort, chainID)).start();

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
            if (oos != null) {
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
        final String id = msg.getId();
        final String txt = msg.getTxt();
        //double tmp = Double.parseDouble(txt);


        Log.d(TAG, "id: " + id + "txt" + txt);
        if (txt != null && txt != "") {
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
//                                       new Intent(com.example.chaintablet.MainActivity.this, TopHorizontalNtbActivity.class)
//                               );
//                               break;
                            case R.id.viewProgress:
                                startActivity(
                                        new Intent(MainActivity.this, ProgressActivity.class)
                                );
                                break;
//                            case R.id.btn_horizontal_top_ntb:
//                                startActivity(
//                                        new Intent(com.example.chaintablet.MainActivity.this, TopHorizontalNtbActivity.class)
//                                );
//                                break;
//                            case R.id.btn_horizontal_coordinator_ntb:
//                                startActivity(
//                                        new Intent(com.example.chaintablet.MainActivity.this, HorizontalCoordinatorNtbActivity.class)
//                                );
//                                break;
                            case R.id.btn_vertical_ntb:
//                                startActivity(
//                                        new Intent(com.example.chaintablet.MainActivity.this, VerticalNtbActivity.class)
//                                );
                                break;
//                            case R.id.btn_samples_ntb:
//                                startActivity(
//                                        new Intent(com.example.chaintablet.MainActivity.this, SamplesNtbActivity.class)
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


    //------------------- CLIENT MODULE -------------------//


    String serverIP = "192.168.43.2";

    int serverPort = 8888;


    Socket sSocket;


//    class ConnectThread implements Runnable {
//
//        String ip;
//        int port;
//        String id;
//
//
//        public ConnectThread() {
//
//        }
//
//        public ConnectThread(String ip, int port, String id) {
//            this.ip = ip;
//            this.port = port;
//            this.id = id;
//
//        }
//
//        @Override
//        public void run() {
//
//
//            try {
//                Thread.sleep(500);
//                sSocket = new Socket(ip, port);
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        tv_server_state.setText("Server Connected.\n" + "(" + sSocket.getInetAddress() + ")");
//                        try {
//                            Thread.sleep(2000);
//
//
//
//                            frameLayout.setVisibility(View.GONE);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            } catch (Exception e) {
////                e.printStackTrace();
//
//                int i = 0;
//
//                while (true) {
//                    i++;
//
//
//                    int finalI = i;
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            tv_server_state.setText("Retry Connecting to Server ... " + finalI);
//                        }
//                    });
//
//                    try {
//                        Thread.sleep(500);
//                        sSocket = new Socket(ip, port);
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                tv_server_state.setText("Server Connected.\n" + "(" + sSocket.getInetAddress() + ")");
//                                try {
//                                    Thread.sleep(2000);
//                                    frameLayout.setVisibility(View.GONE);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        });
//                        break;
//
//                    } catch (Exception ex) {
//                        Log.d(TAG, "failed to connect to server");
////                        ex.printStackTrace();
//                    }
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//            ServerReceiver serverReceiver = null;
//            try {
//                serverReceiver = new ServerReceiver(sSocket);
//                serverReceiver.execute();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        } // run End
//    } // ConnectThread End
//
//
//    class ServerReceiver extends AsyncTask<Void, ContainerMsg, Void> {
//
//        Socket socket;
//        InputStream is;
//        ObjectInputStream ois;
//        OutputStream os;
//        ObjectOutputStream oos;
//
//
//        public ServerReceiver(Socket socket) throws IOException {
//            this.socket = socket;
//            is = socket.getInputStream();
//            ois = new ObjectInputStream(is);
//        }
//
//        @Override
//        protected void onPreExecute() {
//
//            try {
//                os = socket.getOutputStream();
//                oos = new ObjectOutputStream(os);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            ContainerMsg msg = new ContainerMsg("chainID_1000000", "hello", "/192.168.43.2");
//
//            try {
//                oos.writeObject(msg);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//
//            while (ois != null) {
//                ContainerMsg msg = null;
//
//
//                try {
//                    msg = (ContainerMsg) ois.readObject();
//                    Log.d(TAG, msg.getChainID() + " | " + msg.getIngID() + " | " + msg.getConID());
//                    publishProgress(msg);
//
//                } catch (Exception e) {
////                    e.printStackTrace();
//                    msg = new ContainerMsg("System", "Server disconnected", null);
//                    publishProgress(msg);
//
//
//                    break;
//                }
//            }
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(ContainerMsg... values) {
//
//            String id = values[0].getConID();
//            // 위에서 에러가 나면 id 에 system 이라는 값을 주었다. //
//            if (id.equals("System")) {
//                if (sSocket != null) {
//                    try {
//                        sSocket.close();
//                    } catch (IOException e) {
////                        e.printStackTrace();
//                    }
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //------ Client UI ---//
//                        tv_server_state.setText("Server Disconnected..");
//                        frameLayout.setVisibility(View.VISIBLE);
//                    }
//                });
//                new Thread(new ConnectThread(serverIP, serverPort, chainID)).start();
//                return;
//            }
//
//
//        }
//    }

}
