package com.example.monic.foodpre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    static List<String> il = new ArrayList<String>();
    static List<String> ic = new ArrayList<String>();
    ListView lv,lc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        lv=(ListView)findViewById(R.id.lvitems);
        lc=(ListView)findViewById(R.id.lvcost);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Main4Activity.this, android.R.layout.simple_spinner_item, il);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lv.setAdapter(arrayAdapter);
        ArrayAdapter<String> rrayAdapter = new ArrayAdapter<String>(Main4Activity.this, android.R.layout.simple_spinner_item, ic);
        rrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lv.setAdapter(arrayAdapter);
        lc.setAdapter(rrayAdapter);


    }
}
