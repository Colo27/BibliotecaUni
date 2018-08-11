package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CardView cerca = (CardView) findViewById(R.id.cerca_layout);
        CardView account = (CardView) findViewById(R.id.account_layout);

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
                Intent account = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(account);
            }
        });


        CardView stato_prestiti = (CardView) findViewById(R.id.StatoPrestitiLayout);
        stato_prestiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stato = new Intent(getBaseContext(), PrestitiActivity.class);
                startActivity(stato);
            }
        });


        CardView aggiungi_libro = (CardView) findViewById(R.id.aggiungi_libro);
        aggiungi_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuovo = new Intent(getBaseContext(), miei_libri.class);
                startActivity(nuovo);
            }
        });

        CardView info_generali = (CardView) findViewById(R.id.but1);
        info_generali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambia = new Intent (getBaseContext(), InfoGenerali.class);
                startActivity(cambia);
            }
        });




    }
}
