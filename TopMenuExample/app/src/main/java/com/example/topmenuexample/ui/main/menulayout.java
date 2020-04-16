package com.example.topmenuexample.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.topmenuexample.R;


public class menulayout extends Fragment {

    private String title;
    private int page;
    EditText quantity_menu1,quantity_menu2,quantity_menu3,quantity_menu4,quantity_menu5,quantity_menu6;
    Button menu1_pbutton,menu2_pbutton,menu3_pbutton,menu4_pbutton,menu5_pbutton,menu6_pbutton;
    Button menu1_mbutton,menu2_mbutton,menu3_mbutton,menu4_mbutton,menu5_mbutton,menu6_mbutton;
    TextView cost_menu1,cost_menu2,cost_menu3,cost_menu4,cost_menu5,cost_menu6,cost_total,count_total;


    // newInstance constructor for creating fragment with arguments
    public static menulayout newInstance(int page, String title) {
        menulayout fragment = new menulayout();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        Log.d("---","page:"+page+"title"+title);
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

    public void makeMenu(View view){
        quantity_menu1 = view.findViewById(R.id.quantity_menu1);
        quantity_menu2 = view.findViewById(R.id.quantity_menu2);
        quantity_menu3 = view.findViewById(R.id.quantity_menu3);
        quantity_menu4 = view.findViewById(R.id.quantity_menu4);
        quantity_menu5 = view.findViewById(R.id.quantity_menu5);
        quantity_menu6 = view.findViewById(R.id.quantity_menu6);
        cost_menu1 = view.findViewById(R.id.cost_menu1);
        cost_menu2 = view.findViewById(R.id.cost_menu2);
        cost_menu3 = view.findViewById(R.id.cost_menu3);
        cost_menu4 = view.findViewById(R.id.cost_menu4);
        cost_menu5 = view.findViewById(R.id.cost_menu5);
        cost_menu6 = view.findViewById(R.id.cost_menu6);
        cost_total = view.findViewById(R.id.cost_total);
        count_total = view.findViewById(R.id.count_total);


        menu1_pbutton = view.findViewById(R.id.menu1_pbutton);
        menu1_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int i = Integer.parseInt(quantity_menu1.getText().toString());
               i++;
               int totalCost = Integer.parseInt(cost_total.getText().toString());
               int totalCount = Integer.parseInt(count_total.getText().toString());
               int cost = Integer.parseInt(cost_menu1.getText().toString());

               totalCost += cost;
               totalCount += 1;
               quantity_menu1.setText(i+"");
               count_total.setText(totalCount+"");
               cost_total.setText(totalCost+"");
            }
        });
        menu2_pbutton = view.findViewById(R.id.menu2_pbutton);
        menu2_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu2.getText().toString());
                i++;
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu2.getText().toString());
                totalCost += cost;
                totalCount += 1;
                quantity_menu2.setText(i+"");
                count_total.setText(totalCount+"");
                cost_total.setText(totalCost+"");
            }
        });
        menu3_pbutton = view.findViewById(R.id.menu3_pbutton);
        menu3_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu3.getText().toString());
                i++;
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu3.getText().toString());
                totalCost += cost;
                totalCount += 1;
                quantity_menu3.setText(i+"");
                count_total.setText(totalCount+"");
                cost_total.setText(totalCost+"");
            }
        });
        menu4_pbutton = view.findViewById(R.id.menu4_pbutton);
        menu4_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu4.getText().toString());
                i++;
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu4.getText().toString());
                totalCost += cost;
                totalCount += 1;
                quantity_menu4.setText(i+"");
                count_total.setText(totalCount+"");
                cost_total.setText(totalCost+"");
            }
        });
        menu5_pbutton = view.findViewById(R.id.menu5_pbutton);
        menu5_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu5.getText().toString());
                i++;
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu5.getText().toString());
                totalCost += cost;
                totalCount += 1;
                quantity_menu5.setText(i+"");
                count_total.setText(totalCount+"");
                cost_total.setText(totalCost+"");
            }
        });
        menu6_pbutton = view.findViewById(R.id.menu6_pbutton);
        menu6_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu6.getText().toString());
                i++;
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu6.getText().toString());
                totalCost += cost;
                totalCount += 1;
                quantity_menu6.setText(i+"");
                count_total.setText(totalCount+"");
                cost_total.setText(totalCost+"");
            }
        });

        // plus button 끝 //

        // minus button 시작 //
        menu1_mbutton = view.findViewById(R.id.menu1_mbutton);
        menu1_mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu1.getText().toString());
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu1.getText().toString());
                if(i > 0 ){
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu1.setText(i+"");
                    count_total.setText(totalCount+"");
                    cost_total.setText(totalCost+"");
                }
            }
        });

        menu2_mbutton = view.findViewById(R.id.menu2_mbutton);
        menu2_mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu2.getText().toString());
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu2.getText().toString());
                if(i > 0 ){
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu2.setText(i+"");
                    count_total.setText(totalCount+"");
                    cost_total.setText(totalCost+"");
                }
            }
        });
        menu3_mbutton = view.findViewById(R.id.menu3_mbutton);
        menu3_mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu3.getText().toString());
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu3.getText().toString());
                if(i > 0 ){
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu3.setText(i+"");
                    count_total.setText(totalCount+"");
                    cost_total.setText(totalCost+"");
                }
            }
        });
        menu4_mbutton = view.findViewById(R.id.menu4_mbutton);
        menu4_mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu4.getText().toString());
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu4.getText().toString());
                if(i > 0 ){
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu4.setText(i+"");
                    count_total.setText(totalCount+"");
                    cost_total.setText(totalCost+"");
                }
            }
        });
        menu5_mbutton = view.findViewById(R.id.menu5_mbutton);
        menu5_mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu5.getText().toString());
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu5.getText().toString());
                if(i > 0 ){
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu5.setText(i+"");
                    count_total.setText(totalCount+"");
                    cost_total.setText(totalCost+"");
                }
            }
        });
        menu6_mbutton = view.findViewById(R.id.menu6_mbutton);
        menu6_mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(quantity_menu6.getText().toString());
                int totalCost = Integer.parseInt(cost_total.getText().toString());
                int totalCount = Integer.parseInt(count_total.getText().toString());
                int cost = Integer.parseInt(cost_menu6.getText().toString());
                if(i > 0 ){
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu6.setText(i+"");
                    count_total.setText(totalCount+"");
                    cost_total.setText(totalCost+"");
                }
            }
        });

    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_layout, container, false);
        makeMenu(view);

        return view;
    }

}
