package com.example.guest.gestionebiblioteca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MieiLibriActivity extends AppCompatActivity {

    private String mUserType;
    private String mUserId;
    private RecyclerView mListaLibri;
    private DatabaseReference mDatabaseReference;
    private MieiLibriAdapter mLibriAdapter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miei_libri);

        mUserType = getIntent().getStringExtra("userType");

        mAuth = FirebaseAuth.getInstance();
        mUserId = mAuth.getCurrentUser().getUid();

        mListaLibri = (RecyclerView) findViewById(R.id.listaMieiLibri);
        mListaLibri.setLayoutManager(new LinearLayoutManager(this));

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mLibriAdapter = new MieiLibriAdapter(this, this, mDatabaseReference, mUserType, mUserId);
        mListaLibri.setAdapter(mLibriAdapter);
    }
}
