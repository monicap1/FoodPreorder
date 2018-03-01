package com.example.monic.foodpre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.monic.foodpre.R.id.lv;

public class Main3Activity extends AppCompatActivity {

    ListView lv2;
    static String str2;
    String a[]=new String[2];
    ArrayAdapter<String> arrayAdapter;
    List<String> item_list = new ArrayList<String>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Resturants").child(Selection.shop).child("Menu:").child(Main2Activity.str);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lv2=(ListView)findViewById(R.id.lv2);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                item_list.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot s:dataSnapshot.getChildren()){
                    item_list.add(s.getKey()+" : "+s.getValue(String.class));
                }
                arrayAdapter = new ArrayAdapter<String>(Main3Activity.this, android.R.layout.simple_spinner_item, item_list);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                lv2.setAdapter(arrayAdapter);


                Log.d("retieval", "Value is: " + "null");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("retrieval", "Failed to read value.", error.toException());
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               str2  = lv2.getItemAtPosition(position).toString();
                a=str2.split(":");
                Main4Activity.il.add(a[0]);
                Main4Activity.ic.add(a[1]);
                //As you are using Default String Adapter

            }
        });
    }

}


