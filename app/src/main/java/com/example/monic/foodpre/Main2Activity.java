package com.example.monic.foodpre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main2Activity extends AppCompatActivity {

    ListView lv;
    static String str;
    Button cart;
    ArrayAdapter<String> arrayAdapter;
    List<String> menu_list = new ArrayList<String>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Resturants").child(Selection.shop).child("Menu:");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv=(ListView)findViewById(R.id.lv);
        cart=(Button)findViewById(R.id.cart);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                menu_list.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot s:dataSnapshot.getChildren()){
                    menu_list.add(s.getKey());
                }
                arrayAdapter = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_spinner_item, menu_list);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                lv.setAdapter(arrayAdapter);


                Log.d("retieval", "Value is: " + "null");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("retrieval", "Failed to read value.", error.toException());
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                str = lv.getItemAtPosition(position).toString();
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));

            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,Main4Activity.class));
            }
        });
    }

}
