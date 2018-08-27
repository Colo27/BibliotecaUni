package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PrestitiActivity extends AppCompatActivity {

    private static final String TAG = "PrestitiActivity";
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabaseReference;
    private String mUserId;
    private String today;
    private String user;

    // UI
    private EditText mInputText;
    private Button mButtonInvia;

    //private PrestitiListAdapter prestitiListAdapter;
    private RecyclerView rvPrestiti;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statoprestiti);

        user= getIntent().getStringExtra("user");

        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        //setTitle(mAuth.getCurrentUser().getDisplayName());
        setTitle("I miei prestiti");
        mUserId = mUser.getUid();
        rvPrestiti=(RecyclerView)findViewById(R.id.rv_chat);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext());
        rvPrestiti.setLayoutManager(linearLayoutManager);

        // Write a message to the database
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();



       // prestitiListAdapter = new PrestitiListAdapter(this,this,mDatabaseReference,user,mUserId);
       // rvPrestiti.setAdapter(prestitiListAdapter);


    }
    @Override
    public void onStart() {
        super.onStart();
        updateUI();
        //checkDeadLine();
    }
    private void updateUI(){
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // Name, email address, and profile photo Url

            Intent intentToLogin = new Intent(this, LoginActivity.class);
            finish();
            startActivity(intentToLogin);
        }
    }
}
