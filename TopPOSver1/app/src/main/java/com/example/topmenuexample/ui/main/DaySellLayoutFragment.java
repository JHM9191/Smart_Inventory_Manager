package com.example.topmenuexample.ui.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topmenuexample.MainActivity;
import com.example.topmenuexample.R;
import com.example.topmenuexample.adapter.SellListAdapter;
import com.example.topmenuexample.frame.Sales;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DaySellLayoutFragment extends Fragment {

    private String title;
    private int page;
    private Sales sales = new Sales();
    private ArrayList<Sales> salesList = new ArrayList<Sales>();
    RecyclerView list_sellView;
    private SellListAdapter sellListAdapter;
    Button button_closedaysell;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();

        Log.d("---", "daySellLayout isvisible ? :" + isVisibleToUser);
        if (isVisibleToUser) {
            if (sales != null && salesList != null) {
                sales = ((MainActivity) getActivity()).tempSales;
                salesList = ((MainActivity) getActivity()).tempSalesList;

                //getSalesData();

                Log.d("---", "sales : " + sales.toString());
                Log.d("---", "salesList : " + salesList.toString());
                sellView(this.getView());
            }


        } else {
            Log.d("---", "not Visible to User");

        }

    }

    // newInstance constructor for creating fragment with arguments
    public static DaySellLayoutFragment newInstance(int page, String title) {
        DaySellLayoutFragment fragment = new DaySellLayoutFragment();
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
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    public void sellView(View view) {

        list_sellView = view.findViewById(R.id.list_sellView);
        LinearLayoutManager sllm = new LinearLayoutManager(getContext());
        list_sellView.setLayoutManager(sllm);


        sellListAdapter = new SellListAdapter(salesList);
        list_sellView.setAdapter(sellListAdapter);

        button_closedaysell = view.findViewById(R.id.button_closedaysell);


    }

    public void getSalesData(){

        getDataFromHttp task = new getDataFromHttp();
    }



    class getDataFromHttp extends AsyncTask<Void,Void,String>{

        URL url;
        JSONObject jo;
        JSONArray ja;

        public getDataFromHttp(){
            try {
                url = new URL("http://" + MainActivity.IP + "/top/posgetdata.top");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }

        // background 에서 http 요청
        @Override
        protected String doInBackground(Void... voids) {
            return null;
        }


        // 받아온 값 정제 //
        @Override
        protected void onPostExecute(String result) {

        }

    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.daysell_layout, container, false);

        sellView(view);
        return view;
    }


}
