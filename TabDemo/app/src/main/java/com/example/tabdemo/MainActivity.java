package com.example.tabdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tabLayoutID);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.viewPagerID);
        viewPager.setAdapter(pagerAdapter);
        //viewPager.beginFakeDrag();
        tabLayout.setupWithViewPager(viewPager);


    }
}
