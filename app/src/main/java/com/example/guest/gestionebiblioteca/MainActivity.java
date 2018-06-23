package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.statoprestiti;

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
                Intent stato = new Intent(getBaseContext(), statoprestiti.class);
                startActivity(stato);
            }
        });



    }
}