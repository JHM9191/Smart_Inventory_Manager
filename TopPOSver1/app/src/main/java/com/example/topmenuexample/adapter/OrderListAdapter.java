package com.example.topmenuexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topmenuexample.R;
import com.example.topmenuexample.frame.OrderDetail;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.odViewHolder> {

    private final ArrayList<OrderDetail> odlist;

        public class odViewHolder extends RecyclerView.ViewHolder {

            protected ImageView menuImg;
            protected TextView menuName;
            protected TextView menuCount;
            protected TextView menuCost;

            public odViewHolder(View view) {
                super(view);
                this.menuImg = view.findViewById(R.id.order_imgview);
                this.menuName = view.findViewById(R.id.ordername_txt);
                this.menuCost = view.findViewById(R.id.ordercost_txt);
                this.menuCount = view.findViewById(R.id.ordercount_txt);

            }
        }

        public OrderListAdapter(ArrayList<OrderDetail> odlist){
            this.odlist = odlist;
        }


        @NonNull
        @Override
        public odViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.orderdetail_layout,viewGroup,false);

            odViewHolder viewHolder = new odViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull odViewHolder viewHolder, int position) {

        viewHolder.menuImg.setImageResource(odlist.get(position).getImgSrc());
        viewHolder.menuName.setText(odlist.get(position).getMenuName());
        viewHolder.menuCount.setText(odlist.get(position).getMenuCount()+"");
        viewHolder.menuCost.setText(odlist.get(position).getMenuCost()+"");

    }

    @Override
    public int getItemCount() {
        return (null != odlist ? odlist.size() : 0);
    }


}
