package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView mCerca;
    private CardView mAccount;
    private CardView mMieiLibri;
    private CardView mAggiungiLibro;
    private String mTypeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tipo utenza user/admin da login activity
        mTypeUser = getIntent().getStringExtra("userType");

        //UI reference
        mCerca = (CardView) findViewById(R.id.cerca_layout);
        mAccount = (CardView) findViewById(R.id.account_layout);
        mMieiLibri = (CardView) findViewById(R.id.miei_libri);
        mAggiungiLibro = (CardView) findViewById(R.id.aggiungi_libro);

        //settati listener sulle cardview per gestione dei click
        setCardViewListeners();

        if(!mTypeUser.equals("admin")){
            mAggiungiLibro.setVisibility(View.GONE);
        }
        if(mTypeUser.equals("admin")){
            mMieiLibri.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTypeUser = getIntent().getStringExtra("userType");
    }

    private void setCardViewListeners(){
        mCerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cerca = new Intent(getBaseContext(), ScaffaleActivity.class);
                cerca.putExtra("userType", mTypeUser);
                startActivity(cerca);
            }
        });

        mAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(getBaseContext(), AccountActivity.class);
                account.putExtra("userType", mTypeUser);
                startActivity(account);
            }
        });

        mMieiLibri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mieiLibri = new Intent(getBaseContext(), MieiLibriActivity.class);
                mieiLibri.putExtra("userType", mTypeUser);
                startActivity(mieiLibri);
            }
        });

        mAggiungiLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aggiungiLibro = new Intent(getBaseContext(), AggiungiLibroActivity.class);
                aggiungiLibro.putExtra("userType", mTypeUser);
                startActivity(aggiungiLibro);
            }
        });
    }
}
