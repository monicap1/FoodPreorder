package com.example.monic.foodpre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main2Activity extends AppCompatActivity {
    TextView a,b,c;
    String one,two,three;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Resturants").child(Selection.shop).child("Menu:");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        a=(TextView)findViewById(R.id.textView);
        b=(TextView)findViewById(R.id.textView2);
        c=(TextView)findViewById(R.id.textView3);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot s:dataSnapshot.getChildren()){
                    a.setText(a + "," + s.getKey());
                }


                Log.d("retieval", "Value is: " + "null");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("retrieval", "Failed to read value.", error.toException());
            }
        });

             





    }
}
