package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        TextView name = findViewById(R.id.textView3);

        name.setText(user.getDisplayName());

        TextView informazioni = findViewById(R.id.textView5);

        TextView aggiorna = findViewById(R.id.textView6);

        TextView logout = findViewById(R.id.textView7);
    }

}


