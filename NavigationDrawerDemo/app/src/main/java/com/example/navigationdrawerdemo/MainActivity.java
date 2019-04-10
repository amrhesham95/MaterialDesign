package com.example.navigationdrawerdemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private FloatingActionButton fab2;
    private TranslateAnimation translateAnimation;
    private Animation scale;
    Map<String,Integer> dataset;
    private String[] names={"bird","cow","elephant","dog"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scale= AnimationUtils.loadAnimation(this,R.anim.surface);
        initDataset();
        recyclerView =findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyAdapter(dataset,names);
        recyclerView.setAdapter(adapter);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        fab=findViewById(R.id.fab);
        fab2=findViewById(R.id.fab2);
        translateAnimation=new TranslateAnimation(0,-480,0,0);
        translateAnimation.setDuration(500);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setStartOffset(500);
        //TranslateAnimation (int fromXType,
        //                float fromXValue,
        //                int toXType,
        //                float toXValue,
        //                int fromYType,
        //                float fromYValue,
        //                int toYType,
        //                float toYValue)

        fab.setOnClickListener((event)->{

            fab.startAnimation(translateAnimation);

        });

        fab2.setOnClickListener((event)->{
            fab2.startAnimation(scale);


        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(Gravity.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void initDataset(){
        dataset= new HashMap<>();
        dataset.put("0",R.drawable.bird);
        dataset.put("1",R.drawable.cow);
        dataset.put("2",R.drawable.elephant);
        dataset.put("3",R.drawable.dog);
    }
}
