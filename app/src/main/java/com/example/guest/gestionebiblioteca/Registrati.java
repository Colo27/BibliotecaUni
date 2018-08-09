package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Registrati extends AppCompatActivity {

    EditText mConfermaPassword;
    EditText mEmail;
    EditText mPassword;
    EditText mNome;


    private FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"Utente già Loggato",Toast.LENGTH_SHORT);

    }

    //codice da provare con caffo perchè non va l'initUI
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati);
        initUI();

        mAuth = FirebaseAuth.getInstance();
    }
*/

    private void createFirebaseUser(String email, String password,final String nome){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Registration", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//questo non va e non so perchè -> //Toast.makeText(Registrati.this, "Authentication success" Toast.LENGTH_SHORT).show();
                             //showDialog("Registrazione effettuata con successo","Successo",android.R.drawable.ic_dialog_info);

                            //TODO caricare nome su Firebase
                            //setNome(nome);
                            Intent intent= new Intent(Registrati.this,LoginActivity.class);
                            finish();
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Registration", "createUserWithEmail:failure", task.getException());
                            //Chiamare l'alert dialog
                            //showDialog("Errore nella registrazione","Errore",android.R.drawable.ic_dialog_alert);
                            // Toast.makeText(RegisterActivity.this, "Authentication failed." Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });




    }


    //questo mi instupidisce il blocco sotto lol

   /*
    private void setNome(String nome){
        FirebaseUser user= mAuth.getCurrentUser();

        UserProfileChangeRequest changeRequest= new UserProfileChangeRequest.Builder()
                .setDisplayName(nome)
                .build();

        user.updateProfile(changeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.i("setName", "nome caricato con successo");

                } else {
                    Log.i("setName", "nome non caricato con successo");
                }

            }
        });

*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button registrati = findViewById(R.id.btnRegistrati);
        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrati = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(registrati);
            }
        });

        TextView tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent tvLogin = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(tvLogin);


            }

        });


    }
}

