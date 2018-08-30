package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegistratiActivity extends AppCompatActivity {

    EditText mConfermaPassword;
    EditText mEmail;
    EditText mPassword;
    EditText mNome;
    TextView tvLogin;
    Button registrati;



    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mConfermaPassword = findViewById(R.id.etRegPassConf);
        mEmail = findViewById(R.id.etRegEmail);
        mPassword = findViewById(R.id.etRegPass);
        mNome = findViewById(R.id.etRegName);

        registrati = findViewById(R.id.btnRegistrati);
        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNome.getText().toString();
                String mail = mEmail.getText().toString();
                String pass = mPassword.getText().toString();
                String confirmPass = mConfermaPassword.getText().toString();

                if(checkValueRegistration(name, mail, pass, confirmPass)){
                    createFirebaseUser(mail, pass, name);
                }
            }
        });

        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent tvLogin = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(tvLogin);
            }

        });

        mAuth = FirebaseAuth.getInstance();
    }

    private boolean checkValueRegistration(String name, String mail, String pass, String confirmPass){
        boolean check = true;


        if(name.isEmpty()){
            check = false;
            mNome.setError("NON HAI INSERITO IL NOME");

        }

        if(mail.isEmpty() && !mail.contains("@")) {
            check = false;
            mEmail.setError("ERRORE: INSERISCI LA MAIL CORRETTA");
        }

        if(pass.length() < 7) {
            check = false;
            mPassword.setError("INSERISCI ALMENO 7 CARATTERI");
        }

        if(!confirmPass.equals(pass)){
            check = false;
            mConfermaPassword.setError("LA PASSWORD INSERITA NON CORRISPONDE");
        }

        return check;
    }

    private void createFirebaseUser(String email, String password,final String nome){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Registration", "createUserWithEmail:success");

                            caricaNome(nome);


                            Intent intent= new Intent(RegistratiActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Log.w("Registration", "createUserWithEmail:failure", task.getException());
                        }
                    }
                });
    }

    private void caricaNome(String nome) {
        FirebaseUser user = mAuth.getCurrentUser();

        UserProfileChangeRequest changeRequest = new UserProfileChangeRequest.Builder()
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



}

