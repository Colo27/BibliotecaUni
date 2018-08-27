package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabaseReference;
    private String mUserId;
    private String today;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String typeUser = getIntent().getStringExtra("user");



        CardView cerca = (CardView) findViewById(R.id.cerca_layout);
        CardView account = (CardView) findViewById(R.id.account_layout);
        CardView miei_libri = (CardView) findViewById(R.id.miei_libri);
        CardView stato_prestiti = (CardView) findViewById(R.id.StatoPrestitiLayout);
        CardView aggiungi_libro = (CardView) findViewById(R.id.aggiungi_libro);

        if(!typeUser.equals("admin")){
            aggiungi_libro.setVisibility(View.GONE);
        }

        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cerca = new Intent(getBaseContext(), Cerca.class);
                startActivity(cerca);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(getBaseContext(), AccountActivity.class);
                startActivity(account);
            }
        });

        miei_libri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(getBaseContext(), MieiLibri.class);
                startActivity(account);
            }
        });

        stato_prestiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stato = new Intent(getBaseContext(), PrestitiActivity.class);
                startActivity(stato);
            }
        });

        aggiungi_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stato = new Intent(getBaseContext(), AggiungiLibro.class);
                startActivity(stato);
            }
        });


    }


    private void updateUI() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // Name, email address, and profile photo Url

            Intent intentToLogin = new Intent(this, LoginActivity.class);
            finish();
            startActivity(intentToLogin);
        }
    }
}
