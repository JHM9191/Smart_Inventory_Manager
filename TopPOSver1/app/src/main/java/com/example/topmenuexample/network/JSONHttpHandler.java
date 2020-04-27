package com.example.topmenuexample.network;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class JSONHttpHandler {

    public static String getString(URL url, JSONObject jo) {
        String result = null;
        InputStream is = null;
        HttpURLConnection conn = null;
        OutputStream os = null;

        try {
            Thread.sleep(500);
            conn = (HttpURLConnection) url.openConnection();
            Log.d("---", "url: " + url.toString());
            //int responseCode = conn.getResponseCode();
            //Log.d("---", "responseCode : " + responseCode);
           // conn.setUseCaches(false);
            conn.setDoOutput(true);
            //conn.setDoInput(true);
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject message = new JSONObject();
        try {
            message.put("jsonData", jo);
            Log.d("---", "message put: " + message.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            Log.d("---", "message out write: " + message.toString());
            out.write(message.toString());
            out.flush();
            conn.getInputStream();
//          result = convertStr(conn.getInputStream());

            result = "1";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn.getOutputStream() != null) {
                    conn.getOutputStream().close();
                    conn.disconnect();
                }
                if (conn != null) {
                    conn.disconnect();
                    conn = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        conn.disconnect();

        return result;
    }

    public static String convertStr(InputStream is) {
        BufferedReader bi = null;
        StringBuilder sb = new StringBuilder();
        try {
            // 인풋 스트림리더를 버퍼드스트림으로 바꾸어 더 빨리 읽는다. //
            bi = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            // 스트링 빌더를 이용하여 라인별로 읽고 쌓은 후 //
            while ((temp = bi.readLine()) != null) {
                sb.append(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // String 으로 변환한다. //
        return sb.toString();
    }


}

