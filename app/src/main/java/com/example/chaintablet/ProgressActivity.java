package com.example.chaintablet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.example.chaintablet.adapter.ProgressItemAdapter;
import com.example.chaintablet.vo.ContainerVO;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class ProgressActivity extends AppCompatActivity {

    String TAG = "===";

    CircleProgressBar progressBar2, progressBar3, progressBar4;
    int ranNum2, ranNum3, ranNum4;

    ArrayList<ContainerVO> conList = new ArrayList<>();
    RecyclerView recyclerView;
    ProgressItemAdapter progressItemAdapter;
    GridLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_main);


        recyclerView = findViewById(R.id.rv_progress);
        layoutManager = new GridLayoutManager(getApplicationContext(), 3);

        recyclerView.setLayoutManager(layoutManager);

        getData();
        progressItemAdapter = new ProgressItemAdapter(getApplicationContext());

        progressItemAdapter.addContainerList(conList);
        recyclerView.setAdapter(progressItemAdapter);


//        new Thread(new RandomDataThread()).start();

//        initUI2();

        new Thread(new FetchData("chainID_1000000")).start();

        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        lbm.registerReceiver(receiver, new IntentFilter("filter_string"));
    }

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {

                ArrayList<ContainerVO> conList = intent.getParcelableArrayListExtra("conList");
                Log.d(TAG, "conList received : " + conList);
                progressItemAdapter.addContainerList(conList);
                progressItemAdapter.notifyDataSetChanged();
            }
        }
    };


    class FetchData implements Runnable {

        String urlstr = "http://192.168.43.2:8080/top/fetchContainerData.top?chainID=";

        public FetchData(String chainID) {
            urlstr += chainID;
        }

        @Override
        public void run() {
            Log.d(TAG, "fetching data");

            URL url = null;
            try {
                url = new URL(urlstr);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void getData() {


//        ContainerVO c1 = new ContainerVO("CONID_1000000", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000000", "chainID_1000000");
//        ContainerVO c2 = new ContainerVO("CONID_1000001", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000001", "chainID_1000000");
//        ContainerVO c3 = new ContainerVO("CONID_1000002", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000002", "chainID_100000");
//        ContainerVO c4 = new ContainerVO("CONID_1000003", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000003", "chainID_1000000");
//        ContainerVO c5 = new ContainerVO("CONID_1000004", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000004", "chainID_1000000");
//        ContainerVO c6 = new ContainerVO("CONID_1000005", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000005", "chainID_1000000");
//        ContainerVO c7 = new ContainerVO("CONID_1000006", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000006", "chainID_1000000");
//        ContainerVO c8 = new ContainerVO("CONID_1000007", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000007", "chainID_1000000");

//        ContainerVO c1 = new ContainerVO("CONID_1000000", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000000", "chainID_1000001");
//        ContainerVO c2 = new ContainerVO("CONID_1000001", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000001", "chainID_1000001");
//        ContainerVO c3 = new ContainerVO("CONID_1000002", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000002", "chainID_1000001");
//        ContainerVO c4 = new ContainerVO("CONID_1000003", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000003", "chainID_1000001");
//        ContainerVO c5 = new ContainerVO("CONID_1000004", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000004", "chainID_1000001");
//        ContainerVO c6 = new ContainerVO("CONID_1000005", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000005", "chainID_1000001");
//        ContainerVO c7 = new ContainerVO("CONID_1000006", "500", 50.0, 40.0, 20, 20.0, 5, 10.0, 5, 1.0, "ingID_1000006", "chainID_1000001");
//        ContainerVO c8 = new ContainerVO("CONID_1000007", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000007", "chainID_1000001");

//        conList.add(c1);
//        conList.add(c2);
//        conList.add(c3);
//        conList.add(c4);
//        conList.add(c5);
//        conList.add(c6);
//        conList.add(c7);
//        conList.add(c8);


    }


    class RandomDataThread implements Runnable {


        @Override
        public void run() {

            while (true) {

                for (int i = 0; i < conList.size(); i++) {
                    double fullWeight = conList.get(i).getConFullWeight();


                    double ranNum = (Math.random() * fullWeight);

                    Log.d("===", ranNum + "");
                    conList.get(i).setConCurrWeight(ranNum);
                    new Thread(new SendContainerInfoToWebServer(conList.get(i).getConID(), conList.get(i).getConFullWeight(), conList.get(i).getConCurrWeight(), conList.get(i).getConWarningWeight(), conList.get(i).getIngID(), conList.get(i).getChainID())).start();

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressItemAdapter.notifyDataSetChanged();
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    class SendContainerInfoToWebServer implements Runnable {

        String urlstr = "http://192.168.43.2:8080/top/realtimecontainerdata.top?";

        public SendContainerInfoToWebServer(String conID, double conFullWeight, double conCurrWeight, double conWarningWeight, String ingID, String chainID) {
            urlstr += "conID=" + conID + "&conFullWeight=" + conFullWeight + "&conCurrWeight=" + conCurrWeight + "&conWarningWeight=" + conWarningWeight + "&ingID=" + ingID + "&chainID=" + chainID;
        }

        @Override
        public void run() {

            URL url = null;
            try {
                url = new URL(urlstr);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    private void initUI2() {
//
//        // progressBar1 은 실제 측정값 받아올 것 //
//        CircleProgressBar progressBar1 = findViewById(R.id.ItemProgress1);
//        progressBar1.setMax(100);
//        progressBar1.setProgress(30);
//
//        // 나머지 3개의 progressbar 는 랜덤값1~100으로 설정 //
//        progressBar2 = findViewById(R.id.ItemProgress2);
//        progressBar2.setMax(100);
//        progressBar2.setProgress(30);
//
//        progressBar3 = findViewById(R.id.ItemProgress3);
//        progressBar3.setMax(100);
//        progressBar3.setProgress(50);
//
//        progressBar4 = findViewById(R.id.ItemProgress4);
//        progressBar4.setMax(100);
//        progressBar4.setProgress(90);
//
////        while(true) {
////            try {
////                Thread.sleep(1000);
////                randomData();
////            }catch (InterruptedException e){
////                e.printStackTrace();
////            }
////        }
//    }
//
//    public void randomData() {
//
//        ranNum2 = (int) (Math.random() * 100);
//        ranNum3 = (int) (Math.random() * 100);
//        ranNum4 = (int) (Math.random() * 100);
//
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                progressBar2.setProgress(ranNum2);
//                progressBar3.setProgress(ranNum3);
//                progressBar4.setProgress(ranNum4);
//            }
//        });
//
//
//    }


}