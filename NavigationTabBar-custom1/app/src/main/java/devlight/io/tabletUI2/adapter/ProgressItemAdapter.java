package devlight.io.tabletUI2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.ArrayList;

import devlight.io.tabletUI2.R;
import devlight.io.tabletUI2.vo.Container;

public class ProgressItemAdapter extends RecyclerView.Adapter<ProgressItemAdapter.ViewHolder> {

    Context context;

    ArrayList<Container> containerList = new ArrayList<>();

    public ProgressItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return containerList.size();
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
        Container container = containerList.get(position);
        viewHolder.setItem(container);
    }

    // add container one by one
    public void addContainer(Container con) {
        containerList.add(con);
    }

    // add containers in ArrayList form.
    public void addContainerList(ArrayList<Container> conList) {
        this.containerList = conList;
    }

    public Container getContainer(int position) {
        return containerList.get(position);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView ingName;
        CircleProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);

            // reference to view instances
            ingName = itemView.findViewById(R.id.tv_ingName);
            progressBar = itemView.findViewById(R.id.items_graph1);
        }

        public void setItem(Container container) {
            ingName.setText(container.getIngID() + "");
            progressBar.setMax((int)container.getConFullWeight());
            progressBar.setProgress((int)container.getConCurrWeight());
        }
    }

}
