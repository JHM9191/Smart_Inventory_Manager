package com.example.topmenuexample.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.topmenuexample.MainActivity;
import com.example.topmenuexample.frame.Order;
import com.example.topmenuexample.frame.OrderDetail;
import com.example.topmenuexample.R;

import java.util.ArrayList;


public class MenuLayoutFragment extends Fragment {

    private String title;
    private int page;
    EditText quantity_menu1, quantity_menu2, quantity_menu3, quantity_menu4, quantity_menu5, quantity_menu6;
    Button menu1_pbutton, menu2_pbutton, menu3_pbutton, menu4_pbutton, menu5_pbutton, menu6_pbutton;
    Button menu1_mbutton, menu2_mbutton, menu3_mbutton, menu4_mbutton, menu5_mbutton, menu6_mbutton;
    Button order_button;
    TextView cost_menu1, cost_menu2, cost_menu3, cost_menu4, cost_menu5, cost_menu6, cost_total, count_total;
    TextView menu1_name, menu2_name, menu3_name, menu4_name, menu5_name, menu6_name;
    ArrayList<OrderDetail> odlist;
    private int orderCount = 0;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){

        super.setUserVisibleHint(isVisibleToUser);
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();

        Log.d("---","caculateLayout isvisible ? :"+isVisibleToUser);

    }


    // newInstance constructor for creating fragment with arguments
    public static MenuLayoutFragment newInstance(int page, String title) {
        MenuLayoutFragment fragment = new MenuLayoutFragment();
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

    // 버튼별 설정, 하드코딩하였음 //
    public void makeMenu(View view) {


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
        order_button = view.findViewById(R.id.order_button);

        menu1_name = view.findViewById(R.id.menu1_name);
        menu2_name = view.findViewById(R.id.menu2_name);
        menu3_name = view.findViewById(R.id.menu3_name);
        menu4_name = view.findViewById(R.id.menu4_name);
        menu5_name = view.findViewById(R.id.menu5_name);
        menu6_name = view.findViewById(R.id.menu6_name);

        final OrderDetail od1 = new OrderDetail();
        final OrderDetail od2 = new OrderDetail();
        final OrderDetail od3 = new OrderDetail();
        final OrderDetail od4 = new OrderDetail();
        final OrderDetail od5 = new OrderDetail();
        final OrderDetail od6 = new OrderDetail();


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

                quantity_menu1.setText(i + "");
                count_total.setText(totalCount + "");
                cost_total.setText(totalCost + "");


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

                quantity_menu2.setText(i + "");
                count_total.setText(totalCount + "");
                cost_total.setText(totalCost + "");
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

                quantity_menu3.setText(i + "");
                count_total.setText(totalCount + "");
                cost_total.setText(totalCost + "");
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

                quantity_menu4.setText(i + "");
                count_total.setText(totalCount + "");
                cost_total.setText(totalCost + "");
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

                quantity_menu5.setText(i + "");
                count_total.setText(totalCount + "");
                cost_total.setText(totalCost + "");
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

                quantity_menu6.setText(i + "");
                count_total.setText(totalCount + "");
                cost_total.setText(totalCost + "");
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
                if (i > 0) {
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu1.setText(i + "");
                    count_total.setText(totalCount + "");
                    cost_total.setText(totalCost + "");
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
                if (i > 0) {
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu2.setText(i + "");
                    count_total.setText(totalCount + "");
                    cost_total.setText(totalCost + "");

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
                if (i > 0) {
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu3.setText(i + "");
                    count_total.setText(totalCount + "");
                    cost_total.setText(totalCost + "");
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
                if (i > 0) {
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu4.setText(i + "");
                    count_total.setText(totalCount + "");
                    cost_total.setText(totalCost + "");
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
                if (i > 0) {
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu5.setText(i + "");
                    count_total.setText(totalCount + "");
                    cost_total.setText(totalCost + "");
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
                if (i > 0) {
                    i--;
                    totalCost -= cost;
                    totalCount -= 1;
                    quantity_menu6.setText(i + "");
                    count_total.setText(totalCount + "");
                    cost_total.setText(totalCost + "");
                }
            }
        });

        order_button = view.findViewById(R.id.order_button);
        order_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int m1 = Integer.parseInt(quantity_menu1.getText().toString());
                int m2 = Integer.parseInt(quantity_menu2.getText().toString());
                int m3 = Integer.parseInt(quantity_menu3.getText().toString());
                int m4 = Integer.parseInt(quantity_menu4.getText().toString());
                int m5 = Integer.parseInt(quantity_menu5.getText().toString());
                int m6 = Integer.parseInt(quantity_menu6.getText().toString());
                int c1 = m1 * Integer.parseInt(cost_menu1.getText().toString());
                int c2 = m2 * Integer.parseInt(cost_menu2.getText().toString());
                int c3 = m3 * Integer.parseInt(cost_menu3.getText().toString());
                int c4 = m4 * Integer.parseInt(cost_menu4.getText().toString());
                int c5 = m5 * Integer.parseInt(cost_menu5.getText().toString());
                int c6 = m6 * Integer.parseInt(cost_menu6.getText().toString());

                od1.setImgSrc(R.drawable.m1);
                od2.setImgSrc(R.drawable.m2);
                od3.setImgSrc(R.drawable.m3);
                od4.setImgSrc(R.drawable.m4);
                od5.setImgSrc(R.drawable.m5);
                od6.setImgSrc(R.drawable.m6);

                od1.setMenuName(menu1_name.getText().toString());
                od2.setMenuName(menu2_name.getText().toString());
                od3.setMenuName(menu3_name.getText().toString());
                od4.setMenuName(menu4_name.getText().toString());
                od5.setMenuName(menu5_name.getText().toString());
                od6.setMenuName(menu6_name.getText().toString());

                od1.setMenuCount(m1);
                od2.setMenuCount(m2);
                od3.setMenuCount(m3);
                od4.setMenuCount(m4);
                od5.setMenuCount(m5);
                od6.setMenuCount(m6);

                od1.setMenuCost(c1);
                od2.setMenuCost(c2);
                od3.setMenuCost(c3);
                od4.setMenuCost(c4);
                od5.setMenuCost(c5);
                od6.setMenuCost(c6);

                ArrayList<OrderDetail> odlist = new ArrayList<OrderDetail>();

                if (od1.getMenuCount() != 0) {
                    odlist.add(od1);
                }
                if(od2.getMenuCount() != 0) {
                    odlist.add(od2);
                }
                if (od3.getMenuCount() != 0) {
                    odlist.add(od3);
                }
                if (od4.getMenuCount() != 0) {
                    odlist.add(od4);
                }
                if (od5.getMenuCount() != 0) {
                    odlist.add(od5);
                }
                if (od6.getMenuCount() != 0) {
                    odlist.add(od6);
                }

                if(odlist.size() == 0){
                    CustomDialogFragment cdf = CustomDialogFragment.getInstance();
                    cdf.show(getFragmentManager(), CustomDialogFragment.TAG_EVENT_DIALOG);

                }else {

                    ++orderCount;
                    ((MainActivity) getActivity()).realCount = orderCount;
                    Order order = new Order();

                    String ct = ((MainActivity)getActivity()).getCurrentTime();

                    order.setOrderDate(ct);
                    order.setOrderNo("Order" + orderCount + "");
                    order.setTotalCost(Integer.parseInt(cost_total.getText().toString()));
                    order.setTotalCount(Integer.parseInt(count_total.getText().toString()));

                    Log.d("---", order.toString());

                    Log.d("---", odlist.toString());
                    // Intent 또는 bundle 이용해서 OrderListAdapter, OrderLayoutFragment 등으로 odlist,Order 전송,
                    // 값을 받은 상태로 주문 및 결제 창으로 넘어가야함. //
                    // menylayout Fragment -> MainActivity -> OrderLayoutFragment Fragment //
                    ((MainActivity) getActivity()).tempOrder = order;
                    ((MainActivity) getActivity()).tempOlist.add(order);
                    ((MainActivity) getActivity()).tempOdlist = odlist;
                    ((MainActivity) getActivity()).setPageNum(1);
                    ((MainActivity) getActivity()).viewPager.setCurrentItem(1);

                    quantity_menu1.setText(0 + "");
                    quantity_menu2.setText(0 + "");
                    quantity_menu3.setText(0 + "");
                    quantity_menu4.setText(0 + "");
                    quantity_menu5.setText(0 + "");
                    quantity_menu6.setText(0 + "");

                }
            }
        });

    }

    // 여기서 Fragment  View 생성됨. //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_layout, container, false);

        makeMenu(view);


        return view;
    }

}
