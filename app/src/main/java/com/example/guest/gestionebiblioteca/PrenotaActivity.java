package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class PrenotaActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabaseReference;

    private String mUserId;
    private String user;
    private String mAutore;
    private String mTitolo;
    private String mKey;

    private TextView mInputTitolo;
    private TextView mInputAutore;
    private Button btnPrenota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenota);

        mAuth = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        mUserId = mUser.getUid();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();


        mInputAutore=(TextView)findViewById(R.id.ed_autore);
        mInputTitolo=(TextView)findViewById(R.id.ed_titolo);
        btnPrenota=(Button)findViewById(R.id.btnPrenotaLibro);

        user= getIntent().getStringExtra("user");


        mAutore = getIntent().getStringExtra("autore");
        mTitolo = getIntent().getStringExtra("titolo");
        mKey = getIntent().getStringExtra("key");


        mInputAutore.setText("Autore: "+mAutore);
        mInputTitolo.setText("Titolo: "+mTitolo);

        setTitle(mTitolo);


    }
    public void btnPrenotaOnClick(View view) {
        if (user.equals("admin")) {
            Toast.makeText(this, "Operazione non concessa", Toast.LENGTH_LONG).show();
        } else {
            Prenotazione prenotazione = new Prenotazione(new Libro(mAutore, mTitolo), getToday(), getDeadLine());

            mDatabaseReference.child("users").child(mUserId).push().setValue(prenotazione);


            mDatabaseReference.child("users").child("admin").child(mAutore).child(mKey).removeValue();

            Toast.makeText(this, "Prenotazione effettuata con successo", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, PrestitiActivity.class);
            intent.putExtra("user", "user");
            finish();
            startActivity(intent);
        }
    }

    private void updateUI(){
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // Name, email address, and profile photo Url
            Intent intentToLogin = new Intent(this, MainActivity.class);
            finish();
            startActivity(intentToLogin);
        }
    }

    public String getToday() {
        GregorianCalendar gc = new GregorianCalendar();
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(gc.getTime());
        return currentDate;
    }

    public String getDeadLine(){
        GregorianCalendar gc = new GregorianCalendar();

        //Aggiungo 30 giorni alla data odierna
        gc.add(gc.DATE, 30);
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(gc.getTime());

        return currentDate;
    }


}
