package com.example.monic.foodpre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Selection extends AppCompatActivity implements View.OnClickListener {

    Spinner productname_spinner;
    Button selection;
    ArrayAdapter<String> arrayAdapter;

    static String shop;//for storing selected shop

    List<String> shop_list = new ArrayList<String>();//for storing the shop list

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Resturants");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        productname_spinner = (Spinner) findViewById(R.id.category);
        selection=(Button)findViewById(R.id.select_button);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot areasnapshot : dataSnapshot.getChildren()) {
                    shop_list.add(areasnapshot.getKey());//getting every shops and storing it in an array
                }
                arrayAdapter = new ArrayAdapter<String>(Selection.this, android.R.layout.simple_spinner_item, shop_list);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                productname_spinner.setAdapter(arrayAdapter);//setting the array into spinner
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        selection.setOnClickListener(this);

        /*spinner listener*/
        productname_spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        shop=productname_spinner.getSelectedItem().toString();//storimg selected item

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

    }
    public void onClick(View v){
        if(v==selection){
            startActivity(new Intent(Selection.this,Main2Activity.class));
        }
    }
}





