package com.example.guest.gestionebiblioteca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Cerca extends AppCompatActivity {

    private String mUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerca);

        mUserType = getIntent().getStringExtra("userType");
    }
}