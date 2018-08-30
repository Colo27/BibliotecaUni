package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RestituisciActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String mUserId;
    private String mAutore;
    private String mTitolo;
    private String mKey;


    private TextView textTitolo;
    private TextView textAutore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restituisci);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textTitolo = findViewById(R.id.edTitolo);
        textAutore = findViewById(R.id.edAutore);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUserId = mUser.getUid();

        mAutore = getIntent().getStringExtra("autore");
        mTitolo = getIntent().getStringExtra("titolo");
        mKey = getIntent().getStringExtra("key");

        textTitolo.setText(mTitolo);
        textAutore.setText(mAutore);

        final Button restituisci = (Button) findViewById(R.id.btnRestituisciLibro);
        restituisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Libro restituzione = new Libro(mAutore, mTitolo);

                mDatabaseReference.child("users").child("admin").push().setValue(restituzione);
                mDatabaseReference.child("users").child(mUserId).child(mKey).removeValue();

                Toast.makeText(RestituisciActivity.this, "Restituzione effettuata con successo", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(RestituisciActivity.this, MainActivity.class);
                intent.putExtra("userType", "user");
                startActivity(intent);
            }
        });

    }

}
