package com.example.topmenuexample;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.topmenuexample.adapter.SectionsPagerAdapter;
import com.example.topmenuexample.frame.Order;
import com.example.topmenuexample.frame.OrderDetail;
import com.example.topmenuexample.frame.Sales;
import com.example.topmenuexample.ui.main.LoginDialogFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    public static String IP = "192.168.43.2:8080";

    public Order tempOrder = new Order();
    public ArrayList<OrderDetail> tempOdlist = new ArrayList<OrderDetail>();
    int tempPosition = 0;
    public ArrayList<Order> tempOlist = new ArrayList<Order>();
    public ViewPager viewPager;
    public TabLayout tabs;
    public int realCount = 0;
    public int tempTotalCost = 0;
    public String tempClerk = "";
    public String tempStartTime = "";
    public String tempEndTime = "";
    public Sales tempSales = new Sales();
    public ArrayList<Sales> tempSalesList = new ArrayList<Sales>();
    public int sortData = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showLoginDialog("0");


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(setPageNum(0));

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        // Makes tab unclickable
        LinearLayout tabStrip = ((LinearLayout) tabs.getChildAt(0));
        tabStrip.setEnabled(false);
        tabStrip.getChildAt(1).setClickable(false);


        // Makes viewpager unswipable
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }


    public void showLoginDialog(String s) {
        LoginDialogFragment ldf = LoginDialogFragment.getInstance();
        ldf.show(getSupportFragmentManager(), LoginDialogFragment.TAG_Login_Dialog);
        ldf.setCancelable(false);
        if(s.equals("1")){
            ldf.dismiss();
        }
    }


    public String getCurrentTime() {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        String day = dayFormat.format(currentTime);
        String month = monthFormat.format(currentTime);
        String year = yearFormat.format(currentTime);
        String time = timeFormat.format(currentTime);

        String showTime = (year + "-" + month + "-" + day + " " + time);
        return showTime;
    }

    public String getDay() {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        String day = dayFormat.format(currentTime);
        String month = monthFormat.format(currentTime);
        String year = yearFormat.format(currentTime);


        String dayTime = (year + "-" + month + "-" + day);
        return dayTime;
    }


    public int setPageNum(int positon) {
        tempPosition = positon;
        return tempPosition;
    }





}
