package com.example.layoutsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FrameActivity extends AppCompatActivity {
    ListView listView;
    String strings[]={"1","2","3","4","5","6","7","8"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        listView=findViewById(R.id.listViewID);
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strings));

    }
}
