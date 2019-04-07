package com.example.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Map <String,Integer> dataset;
    private String[] names={"bird","cow","elephant","dog"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataset();
        recyclerView =findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyAdapter(dataset,names);
        recyclerView.setAdapter(adapter);
    }
    public void initDataset(){
        dataset= new HashMap<>();
        dataset.put("0",R.drawable.bird);
        dataset.put("1",R.drawable.cow);
        dataset.put("2",R.drawable.elephant);
        dataset.put("3",R.drawable.dog);
    }
}
