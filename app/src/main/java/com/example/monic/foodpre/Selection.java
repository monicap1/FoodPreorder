package com.example.monic.foodpre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.monic.foodpre.R.id.spinner;

public class Selection extends AppCompatActivity {

    Spinner s;
    String[] KFC;
    String[] Menu;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        s=(Spinner)findViewById(R.id.category);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Resturants");
        KFC=new String[10];
        Spinner productname_spinner =(Spinner) findViewById(R.id.category);



            myRef.child("Resturants").child("KFC").child("Menu").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot datasnapshot) {

                final List<String> KFC = new ArrayList<String>();
                }
                for(DataSnapshot areasnapshot:datasnapshot.getChildren())
                {
                    String KFC = areasnapshot.getValue(String.class);
                    KFC.add(KFC);

                }
                                                                                                }

                    ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<String>(Selection.this, android.R.layout.simple_spinner_item,KFC);
        ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(skularAdapter);
    }
                Log.d("retieval", "Value is: " );



            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("retrieval", "Failed to read value.", error.toException());
            }
        });






