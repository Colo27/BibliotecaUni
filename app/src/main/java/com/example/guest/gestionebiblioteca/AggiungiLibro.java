package com.example.guest.gestionebiblioteca;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AggiungiLibro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private DatabaseReference mDatabaseReference;
    private String mUserId;
    private String user;

    //UI
    private EditText mTitolo;
    private EditText mAutore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_libro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user= getIntent().getStringExtra("user");

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        setTitle(mAuth.getCurrentUser().getDisplayName());
        mUserId = mUser.getUid();

        mAutore =(EditText)findViewById(R.id.ed_autore);
        mTitolo=(EditText) findViewById(R.id.ed_titolo);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        Button aggiungiLibro = findViewById(R.id.button_add);
        aggiungiLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseReference.child("users").child("admin").push().setValue(new Libro(mAutore.getText().toString(), mTitolo.getText().toString()));
                Intent intent = new Intent(AggiungiLibro.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
