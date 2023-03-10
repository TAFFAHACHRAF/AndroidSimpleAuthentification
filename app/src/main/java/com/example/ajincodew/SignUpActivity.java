package com.example.ajincodew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

public class SignUpActivity extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText password;
    EditText passconfirm;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup_main);
        this.save=findViewById(R.id.login);
        this.username=findViewById(R.id.username);
        this.email=findViewById(R.id.emailLogin);
        this.password=findViewById(R.id.passLogin);
        this.passconfirm=findViewById(R.id.passconf);

    }

    public void Signup(){
        // Créer un objet SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("auth_preferences", MODE_PRIVATE);

        // Créer un objet Editor
            SharedPreferences.Editor editor = sharedPreferences.edit();

        // Stocker le login et le mot de passe dans les préférences
            editor.putString("username", username.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("password", password.getText().toString());

        // Enregistrer les modifications dans les préférences
        editor.apply();

        // move into login activity

        Intent  intent=new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}