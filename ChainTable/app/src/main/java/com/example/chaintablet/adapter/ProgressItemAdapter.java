package com.example.chaintablet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.example.chaintablet.R;
import com.example.chaintablet.vo.ContainerVO;

import java.util.ArrayList;


public class ProgressItemAdapter extends RecyclerView.Adapter<ProgressItemAdapter.ViewHolder> {

    Context context;

    ArrayList<ContainerVO> containerVOList = new ArrayList<>();

    public ProgressItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return containerVOList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ContainerVO containerVO = containerVOList.get(position);
        viewHolder.setItem(containerVO);
    }

    // add container one by one
    public void addContainer(ContainerVO con) {
        containerVOList.add(con);
    }

    // add containers in ArrayList form.
    public void addContainerList(ArrayList<ContainerVO> conList) {
        this.containerVOList = conList;
    }

    public ContainerVO getContainer(int position) {
        return containerVOList.get(position);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView ingName, ingState;

        CircleProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);

            // reference to view instances
            ingName = itemView.findViewById(R.id.tv_ingName);
            ingState = itemView.findViewById(R.id.tv_ingState);
            progressBar = itemView.findViewById(R.id.items_graph1);

        }

        public void setItem(ContainerVO containerVO) {
            ingName.setText(containerVO.getIngName() + "");
            ingState.setText(containerVO.getConCurrQuantity() + "/" + containerVO.getConFullQuantity() + "개 ("
                    + containerVO.getConCurrWeight() + "/" + containerVO.getConFullWeight() + "kg)\n경고수준: " + containerVO.getConWarningWeight() + "kg");
            progressBar.setMax((int) containerVO.getConFullWeight());
            progressBar.setProgress((int) containerVO.getConCurrWeight());

        }
    }

}
