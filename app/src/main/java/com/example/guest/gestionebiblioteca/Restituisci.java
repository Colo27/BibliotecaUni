package com.example.guest.gestionebiblioteca;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Restituisci extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String mUserId;
    private String user;
    private String mAutore;
    private String mTitolo;
    private String mKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restituisci);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mUser=mAuth.getCurrentUser();
        mUserId = mUser.getUid();


        mAutore = getIntent().getStringExtra("autore");
        mTitolo = getIntent().getStringExtra("titolo");
        mKey = getIntent().getStringExtra("key");

        final Button restituisci = (Button) findViewById(R.id.btnRestituisciLibro);
        restituisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseReference.child("users").child("admin").push().setValue(restituisci);


                mDatabaseReference.child("users").child(mUserId).child(mKey).removeValue();


            }
        });

    }

}
