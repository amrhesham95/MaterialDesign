package com.example.layoutsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button frameLayoutBtn;
    Button linearLayoutBtn;
    Button gridLayoutBtn;
    Button relativeLayoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayoutBtn=findViewById(R.id.frameLayoutBtnID);
        linearLayoutBtn=findViewById(R.id.linearLayoutBtnID);
        gridLayoutBtn=findViewById(R.id.gridLayoutBtnID);
        relativeLayoutBtn=findViewById(R.id.relativeLayoutBtnID);
        frameLayoutBtn.setOnClickListener((event)->{
            Intent intent=new Intent(getApplicationContext(),FrameActivity.class);
            startActivity(intent);
        });
        linearLayoutBtn.setOnClickListener((event)->{
            Intent intent=new Intent(getApplicationContext(), LinearActivity.class);
            startActivity(intent);
        });
        gridLayoutBtn.setOnClickListener((event)->{
            Intent intent=new Intent(getApplicationContext(), GridActivity.class);
            startActivity(intent);
        });
        relativeLayoutBtn.setOnClickListener((event)->{
            Intent intent=new Intent(getApplicationContext(), RelativeActivity.class);
            startActivity(intent);
        });
    }
}
