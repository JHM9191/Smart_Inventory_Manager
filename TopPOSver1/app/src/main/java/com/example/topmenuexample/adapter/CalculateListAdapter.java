package com.example.topmenuexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topmenuexample.frame.Order;
import com.example.topmenuexample.R;

import java.util.ArrayList;

public class CalculateListAdapter extends RecyclerView.Adapter<CalculateListAdapter.ccViewHolder> {

    private final ArrayList<Order> olist;

    public class ccViewHolder extends RecyclerView.ViewHolder{

        protected TextView cctxt_orderno,cctxt_totalcount,cctxt_totalcost,cctxt_ordertime;

        public ccViewHolder(View view){
            super(view);
            this.cctxt_orderno = view.findViewById(R.id.cctxt_orderno);
            this.cctxt_totalcost = view.findViewById(R.id.cctxt_totalcost);
            this.cctxt_totalcount = view.findViewById(R.id.cctxt_totalcount);
            this.cctxt_ordertime = view.findViewById(R.id.cctxt_ordertime);

        }

    }

    public CalculateListAdapter(ArrayList<Order> olist){
        this.olist = olist;

    }


    @NonNull
    @Override
    public ccViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calculatedetail_list,viewGroup,false);
        ccViewHolder viewHolder = new ccViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ccViewHolder viewHolder, int position) {

        viewHolder.cctxt_orderno.setText(olist.get(position).getOrderNo()+"");
        viewHolder.cctxt_totalcost.setText(olist.get(position).getTotalCost()+"");
        viewHolder.cctxt_totalcount.setText(olist.get(position).getTotalCount()+"");
        viewHolder.cctxt_ordertime.setText(olist.get(position).getOrderDate()+"");

    }


    @Override
    public int getItemCount() {
        return (null != olist ? olist.size() : 0);
    }


}
