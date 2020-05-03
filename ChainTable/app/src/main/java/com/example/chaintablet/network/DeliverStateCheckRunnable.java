package com.example.chaintablet.network;

import android.util.Log;

import com.example.chaintablet.MainActivity;


public class DeliverStateCheckRunnable implements Runnable {
    String TAG = "===";

    //    String urlstr = "http://70.12.231.236:8080/top/deliverStateCheck.top?chainID=";
    String urlstr;

    String result;

    public DeliverStateCheckRunnable(String chainID) {
        urlstr = "http://" + MainActivity.IP + "/top/deliverStateCheck.top?chainID=";
        urlstr += chainID;
    }

    @Override
    public void run() {

        try {
            result = HttpHandler.getString(urlstr);
            Log.d(TAG, "result : " + result);


        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result!=null && result.equals("ondelivery")) {
            result = "배송중";
        } else if (result.equals("ready")) {
            result = "배송준비중";
        }

        MainActivity.deliverStatusFromServer = result;

    }


}
