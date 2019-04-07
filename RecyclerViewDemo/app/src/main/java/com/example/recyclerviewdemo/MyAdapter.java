package com.example.recyclerviewdemo;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    private Map<String,Integer> Dataset;
    private String[] names;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        CardView cardView;
        FrameLayout frameLayout;
        public MyViewHolder(View v) {
            super(v);
            textView=v.findViewById(R.id.info_text);
            frameLayout=v.findViewById(R.id.frame_layout);

        }
    }
    public MyAdapter(Map<String,Integer> Dataset,String[] names) {
        this.Dataset = Dataset;
        this.names=names;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mycardview,viewGroup,false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.textView.setText(names[position]);
        myViewHolder.frameLayout.setBackgroundResource(Dataset.get(String.valueOf(position)));
    }



    @Override
    public int getItemCount() {
        return Dataset.size();
    }
}
