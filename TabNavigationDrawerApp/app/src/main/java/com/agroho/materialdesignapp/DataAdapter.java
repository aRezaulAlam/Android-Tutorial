package com.agroho.materialdesignapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by ASUS on 7/17/2015.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ClickListener clickListener;
    private Context context;
    List<Information> data = Collections.emptyList();
    public DataAdapter(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            icon = (ImageView)itemView.findViewById(R.id.listIcon);
            title = (TextView)itemView.findViewById(R.id.listText);
        }

        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context,SecondActivity.class));
            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }
        }

    }

    public interface ClickListener{
        public void itemClicked(View view, int position);
    }

}
