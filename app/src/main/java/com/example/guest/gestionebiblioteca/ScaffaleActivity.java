package com.example.guest.gestionebiblioteca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScaffaleActivity extends AppCompatActivity {

    private String mUserType;
    private RecyclerView mListaLibri;
    private DatabaseReference mDatabaseReference;
    private ScaffaleAdapter mLibriAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerca);

        mUserType = getIntent().getStringExtra("userType");

        mListaLibri = (RecyclerView) findViewById(R.id.listaLibri);
        mListaLibri.setLayoutManager(new LinearLayoutManager(this));

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mLibriAdapter = new ScaffaleAdapter(this, this, mDatabaseReference, mUserType);
        mListaLibri.setAdapter(mLibriAdapter);
    }
}