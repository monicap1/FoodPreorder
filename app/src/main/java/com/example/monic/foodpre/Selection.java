package com.example.monic.foodpre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Selection extends AppCompatActivity {

    Spinner s;
    String[] a;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        s=(Spinner)findViewById(R.id.category);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Resturants");
        a=new String[10];
        Spinner productname_spinner =(Spinner) findViewById(R.id.s);

        productname_spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        System.out.println(item.toString());     //prints the text in spinner item.

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    a[i]=snapshot.getKey();i++;
                }
                Log.d("retieval", "Value is: " );
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("retrieval", "Failed to read value.", error.toException());
            }
        });
        Adapter adapter=new
        s.setAdapter();



    }
}
