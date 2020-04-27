package com.example.topmenuexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topmenuexample.R;
import com.example.topmenuexample.frame.Sales;

import java.util.ArrayList;

public class SellListAdapter extends RecyclerView.Adapter<SellListAdapter.sViewHolder> {

    private final ArrayList<Sales> salesList;

    public class sViewHolder extends RecyclerView.ViewHolder{

        protected TextView txt_sellDate,txt_sellCount,txt_sellCost,txt_sellAdmin;

        public sViewHolder(View view){
            super(view);
            this.txt_sellDate = view.findViewById(R.id.txt_sellDate);
            this.txt_sellCount = view.findViewById(R.id.txt_sellCount);
            this.txt_sellCost= view.findViewById(R.id.txt_sellCost);
            this.txt_sellAdmin = view.findViewById(R.id.txt_sellAdmin);
        }
    }

    public SellListAdapter(ArrayList<Sales> salesList){

        this.salesList = salesList;

    }


    @NonNull
    @Override
    public sViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.daysell_list,viewGroup,false);
        sViewHolder viewHolder = new sViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull sViewHolder viewHolder, int position) {

        viewHolder.txt_sellAdmin.setText(salesList.get(position).getAdmin());
        viewHolder.txt_sellCost.setText(salesList.get(position).getSellCost()+"");
        viewHolder.txt_sellCount.setText(salesList.get(position).getSellCount()+"");
        viewHolder.txt_sellDate.setText(salesList.get(position).getSellDate());

    }

    @Override
    public int getItemCount() {
        return (null != salesList ? salesList.size() : 0);
    }





}
