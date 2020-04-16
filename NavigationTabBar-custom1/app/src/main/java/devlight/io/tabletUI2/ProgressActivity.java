package devlight.io.tabletUI2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dinuscxj.progressbar.CircleProgressBar;

import devlight.io.tabletUI2.R;

public class ProgressActivity extends AppCompatActivity {

    CircleProgressBar progressBar2,progressBar3,progressBar4;
    int ranNum2,ranNum3,ranNum4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_main);
        initUI2();
    }

    private void initUI2() {

        // progressBar1 은 실제 측정값 받아올 것 //
        CircleProgressBar progressBar1 = findViewById(R.id.ItemProgress1);
        progressBar1.setMax(100);
        progressBar1.setProgress(30);

        // 나머지 3개의 progressbar 는 랜덤값1~100으로 설정 //
        progressBar2 = findViewById(R.id.ItemProgress2);
        progressBar2.setMax(100);
        progressBar2.setProgress(30);

        progressBar3 = findViewById(R.id.ItemProgress3);
        progressBar3.setMax(100);
        progressBar3.setProgress(50);

        progressBar4 = findViewById(R.id.ItemProgress4);
        progressBar4.setMax(100);
        progressBar4.setProgress(90);

//        while(true) {
//            try {
//                Thread.sleep(1000);
//                randomData();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
    }

    public void randomData(){

        ranNum2 = (int)(Math.random()*100);
        ranNum3 = (int)(Math.random()*100);
        ranNum4 = (int)(Math.random()*100);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar2.setProgress(ranNum2);
                progressBar3.setProgress(ranNum3);
                progressBar4.setProgress(ranNum4);
            }
        });


    }


}