package com.example.guest.gestionebiblioteca;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class aggiungi_libro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_libro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //non sono sicuro di cosa faccia questo :c
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //ho aggiunto questo come prova per vedere se adesso va su aggiungi_libro
        //se qualcosa va in troia ricordarsi che ho aggiunto questo e quindi cancellarlo
        Button aggiungi_libro = findViewById(R.id.aggiungi_libro);
        aggiungi_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aggiungi_libro = new Intent(getBaseContext(), aggiungi_libro.class);
                startActivity(aggiungi_libro);
            }
        });
    }

}
