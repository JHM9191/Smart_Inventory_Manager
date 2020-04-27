package com.example.topmenuexample.ui.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topmenuexample.MainActivity;
import com.example.topmenuexample.adapter.OrderListAdapter;
import com.example.topmenuexample.frame.OrderDetail;
import com.example.topmenuexample.R;
import com.example.topmenuexample.frame.Order;
import com.example.topmenuexample.network.JSONHttpHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
/*
* 선택된 메뉴를 담고 결제시 주문내역을 보여주는 OrderFragment
* */
public class OrderLayoutFragment extends Fragment {

    private String title;
    private int page;
    RecyclerView list_recyclerview;
    private ArrayList<OrderDetail> odlist = new ArrayList<OrderDetail>();
    private Order order = new Order();
    private com.example.topmenuexample.adapter.OrderListAdapter OrderListAdapter;
    TextView txt_orderCost, txt_orderCount, txt_orderDate, txt_orderNo;
    private JSONObject jo;
    private JSONArray ja;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();

        Log.d("---", "setUserVisibleHint");
        if (isVisibleToUser) {

            odlist = ((MainActivity) getActivity()).tempOdlist;
            order = ((MainActivity) getActivity()).tempOrder;
            Log.d("---", "Get from menu" + "odlist: " + odlist + "Order" + order);

            sendJsonOrderData(order);
            sendJsonOdlistData(odlist);

            makeList(this.getView());

        } else {
            Log.d("---", "NotVisibleToUser");

        }

    }


    // newInstance constructor for creating fragment with arguments
    public static OrderLayoutFragment newInstance(int page, String title) {

        Log.d("---", "newInstance");

        OrderLayoutFragment fragment = new OrderLayoutFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        Log.d("---", "page:" + page + "title" + title);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("---", "onCreate");

        if (savedInstanceState != null) {
            Log.d("---", savedInstanceState.getString("bundle"));
            page = getArguments().getInt("someInt", 0);
            title = getArguments().getString("someTitle");
        }
        super.onCreate(savedInstanceState);

    }


    public void sendJsonOrderData(Order order) {
        order = this.order;
        jo = new JSONObject();
        try {
            jo.put("orderDate", order.getOrderDate());
            jo.put("orderCount", order.getTotalCount());
            jo.put("orderCost", order.getTotalCost());
            jo.put("orderNo", order.getOrderNo());
            jo.put("chainID", "chainID_1000000");
           sendToHttpTaskOrder task = new sendToHttpTaskOrder(jo);
            task.execute();
        } catch (Exception e) {
            Log.d("---", "error occured in sendOrderData");
            e.printStackTrace();
        }
    }

    public void sendJsonOdlistData(ArrayList<OrderDetail> odlist){
        odlist = this.odlist;
        JSONObject odjo = new JSONObject();
        try{
            for(int i = 0;i<odlist.size();i++){
                odjo.put("menu"+(i+1),odlist.get(i));
            }
            odjo.put("chainID", "chainID_1000000");
            sendToHttpTaskOdlist task = new sendToHttpTaskOdlist(odjo);
            task.execute();
        }catch(Exception e){
            Log.d("---", "error occured in sendOrderDetailListData");
            e.printStackTrace();
        }

    }

    class sendToHttpTaskOrder extends AsyncTask<Void, Void, String> {

        URL url;
        JSONObject jo;

        public sendToHttpTaskOrder(JSONObject jo) {
            try {
                this.jo = jo;
                url = new URL("http://192.168.43.2:8080/top/posorder.top");

            } catch (MalformedURLException e) {
                Log.d("---", "Error occured in urlconnection");
                e.printStackTrace();
            }
        }



        @Override
        protected String doInBackground(Void... voids) {
            Log.d("---", "Background Processing");
            return JSONHttpHandler.getString(url, jo);
//            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            if (result != null && result != "") {
                Log.d("---", "getFrom Server" + result.trim());
                if (result.trim().equals("success")) {
                    Log.d("---", "Data Inserted");
                } else {
                    Log.d("---", "no msg came from Server");
                }
            }

        }

    }

    class sendToHttpTaskOdlist extends AsyncTask<Void, Void, String> {

        URL url;
        JSONObject jo;

        public sendToHttpTaskOdlist(JSONObject jo) {
            try {
                this.jo = jo;
                url = new URL("http://192.168.43.2:8080/top/posorderdetail.top");

            } catch (MalformedURLException e) {
                Log.d("---", "Error occured in urlconnection");
                e.printStackTrace();
            }
        }



        @Override
        protected String doInBackground(Void... voids) {
            Log.d("---", "Background Processing");
            return JSONHttpHandler.getString(url, jo);
//            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            if (result != null && result != "") {
                Log.d("---", "getFrom Server" + result.trim());
                if (result.trim().equals("success")) {
                    Log.d("---", "Data Inserted");
                } else {
                    Log.d("---", "no msg came from Server");
                }
            }

        }

    }





    public void makeList(View view) {
        Log.d("---", "makeList");


        txt_orderNo = view.findViewById(R.id.txt_orderNo);
        txt_orderDate = view.findViewById(R.id.txt_orderDate);
        txt_orderCost = view.findViewById(R.id.txt_orderCost);
        txt_orderCount = view.findViewById(R.id.txt_orderCount);

        list_recyclerview = view.findViewById(R.id.list_recyclerview);
        LinearLayoutManager orderLinearLayoutManager = new LinearLayoutManager(getContext());
        list_recyclerview.setLayoutManager(orderLinearLayoutManager);
        OrderListAdapter = new OrderListAdapter(odlist);

        list_recyclerview.setAdapter(OrderListAdapter);

        txt_orderNo.setText(order.getOrderNo() + "");
        txt_orderDate.setText(order.getOrderDate() + "");
        txt_orderCount.setText(order.getTotalCount() + "");
        txt_orderCost.setText(order.getTotalCost() + "");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("---", "onCreateView");

        View view = inflater.inflate(R.layout.order_layout, container, false);

        makeList(view);

        return view;
    }


}
