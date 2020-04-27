package com.example.chaintablet.network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {
    public static String getString(String urlstr){
        String result = null;
        URL url = null;
        HttpURLConnection hcon = null;
        InputStream is = null;
        try{
            //url 객체 생성//
            url = new URL(urlstr);
            //url 객체를 통해 접속 //
            hcon = (HttpURLConnection) url.openConnection();
            // 커낵션 타임이 초가 넘어가면 커낵션 취소 //
            hcon.setConnectTimeout(10000);
            // GET 메써드로 요청받기 //
            hcon.setRequestMethod("POST");
            is = new BufferedInputStream(hcon.getInputStream());
            //convertStr 객체를 통해 is값 변환 (하단에 선언) //
            result = convertStr(is);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static String convertStr(InputStream is){
        String result = null;
        BufferedReader bi = null;
        StringBuilder sb = new StringBuilder();
        try{
            // 인풋 스트림리더를 버퍼드스트림으로 바꾸어 더 빨리 읽는다. //
            bi = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            // 스트링 빌더를 이용하여 라인별로 읽고 쌓은 후 //
            while ((temp = bi.readLine()) != null){
                sb.append(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // String 으로 변환한다. //
        return sb.toString();
    }

}
