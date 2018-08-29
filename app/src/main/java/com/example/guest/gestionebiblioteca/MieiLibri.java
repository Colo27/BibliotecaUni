package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MieiLibri extends AppCompatActivity {

    private static final String TAG="GalleryActivity";
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabaseReference;
    private String mUserId;
    private String user;
    private String mAutore;
    private String mTitolo;
    private String mScadenza;
    private String mKey;

    private TextView mInputTitolo;
    private TextView mInputAutore;
    private TextView mInputScadenza;
    private Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miei_libri);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        mUserId = mUser.getUid();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();


        //mInputAutore=(TextView)findViewById(R.id.ed_autore);
        //mInputTitolo=(TextView)findViewById(R.id.ed_titolo);

        //mInputScadenza=(TextView)findViewById(R.id.ed_scadenza);
        //btnRemove=(Button)findViewById(R.id.btnRemove);

        user= getIntent().getStringExtra("user");


        //mAutore=getIntent().getStringExtra("autore");
        //mTitolo= getIntent().getStringExtra("titolo");

        //mKey= getIntent().getStringExtra("key");
        //mScadenza = getIntent().getStringExtra("scadenza");


        //mInputAutore.setText("Autore: "+mAutore);
        //mInputTitolo.setText("Titolo:"+mTitolo);
        //mInputScadenza.setText("Data scadenza: "+mScadenza);

        //setTitle(mTitolo);
    }

    /*public void btnRemoveOnClick(View view){

        mDatabaseReference.child("users").child(mUserId).child(mKey).removeValue();

        Toast.makeText(this,"Riconsegna effettuata con successo",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra("user","user");
        finish();
        startActivity(intent);


    }
    private void updateUI(){
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // Name, email address, and profile photo Url

            Intent intentToLogin = new Intent(this, LoginActivity.class);
            finish();
            startActivity(intentToLogin);
        }
    }*/
}
