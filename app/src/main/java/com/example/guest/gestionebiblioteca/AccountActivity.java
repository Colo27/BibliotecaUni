package com.example.guest.gestionebiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String mTypeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mTypeUser = getIntent().getStringExtra("userType");

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        TextView name = findViewById(R.id.profileName);

        if(!mTypeUser.equals("admin")) {
            name.setText(mUser.getDisplayName());
        }
        else{
            name.setText("Admin");
        }

        TextView logout = findViewById(R.id.logoutTv);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent logout = new Intent(AccountActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });

    }

}


