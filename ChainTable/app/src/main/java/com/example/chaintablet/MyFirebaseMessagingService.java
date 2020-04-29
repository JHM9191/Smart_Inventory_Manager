package com.example.chaintablet;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.chaintablet.vo.ContainerVO;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    String TAG = "===";


    ArrayList<ContainerVO> conList = MainActivity.conList;
    String title;
    String body;
    String list;


    public MyFirebaseMessagingService() {

    }


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {


        title = remoteMessage.getNotification().getTitle();
        body = remoteMessage.getNotification().getBody();
        Log.d(TAG, "title : " + title);
        Log.d(TAG, "body : " + body);
        if (title.equals("truck1")) {
            MainActivity.orderID = body;
            return;
        }

        if (!title.equals(MainActivity.chainID)) {
            return;
        } else {
            conList = new ArrayList<>();
        }

        list = remoteMessage.getData().get("list");


        Log.d(TAG, "list : " + list);

        JSONArray ja = null;
        try {
            ja = new JSONArray(list);
            Log.d(TAG, "ja : " + ja);
            for (int i = 0; i < ja.length(); i++) {



                JSONObject jo = new JSONObject();
                jo = (JSONObject) ja.get(i);
                String chainName = (String) jo.get("chainName");

                if (chainName.equals(MainActivity.chainName)) {
                    String conID = (String) jo.get("conID");
                    String conSize = (String) jo.get("conSize");
                    double conMaxWeight = (double) jo.get("conMaxWeight");
                    String conRegDate = (String) jo.get("conRegDate");
                    Object conUpdateDate = (Object) jo.get("conUpdateDate");
                    if (conUpdateDate == null) {
                        conUpdateDate = "";
                    } else {
                        Log.d(TAG, conUpdateDate + "");
                        conUpdateDate = conUpdateDate + "";
                    }
                    double conFullWeight = (double) jo.get("conFullWeight");
                    int conFullQuantity = (int) jo.get("conFullQuantity");
                    double conWarningWeight = (double) jo.get("conWarningWeight");
                    int conWarningQuantity = (int) jo.get("conWarningQuantity");
                    double conCurrWeight = (double) jo.get("conCurrWeight");
                    int conCurrQuantity = (int) jo.get("conCurrQuantity");
                    double conUnitWeight = (double) jo.get("conUnitWeight");
                    String ingID = (String) jo.get("ingID");
                    String ingName = (String) jo.get("ingName");
                    double ingWeight = (double) jo.get("ingWeight");
                    String chainID = (String) jo.get("chainID");

                    String hqID = (String) jo.get("hqID");
                    String hqName = (String) jo.get("hqName");
                    ContainerVO container = new ContainerVO(conID, conSize, conMaxWeight, conRegDate,
                            conUpdateDate + "", conFullWeight, conFullQuantity, conWarningWeight, conWarningQuantity,
                            conCurrWeight, conCurrQuantity, conUnitWeight, ingID, ingName, ingWeight, chainID, chainName, hqID, hqName);
                    conList.add(container);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        Log.d(TAG, "conList sent : " + conList);

        Intent intent = new Intent("filter_string");
        intent.putParcelableArrayListExtra("conList", (ArrayList<? extends Parcelable>) conList);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        Intent intent2 = new Intent(this, MainActivity.class);


    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);


        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.d("===", "getting new token fail!");
                    return;
                }

                String token = task.getResult().getToken();

                String msg = getString(R.string.msg_token_fmt, token);
                Log.d(TAG, msg);
                Toast.makeText(MyFirebaseMessagingService.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
