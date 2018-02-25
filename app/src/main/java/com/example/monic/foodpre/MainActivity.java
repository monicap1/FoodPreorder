package com.example.monic.foodpre;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(this);


    }

    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {

                            Log.w("signin", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Intent intent = new Intent(MainActivity.this, Selection.class);
                            startActivity(intent);
                            finish();

                        }
                    }
                });

        // [END sign_in_with_email]
    }





    //button click definition

    public void onClick(View v){
        if(v==b1){
            signIn(e1.getText().toString(),e2.getText().toString());

        }

    }
}
