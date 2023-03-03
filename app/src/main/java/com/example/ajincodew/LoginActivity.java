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



public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        this.login=findViewById(R.id.login);
        this.email=findViewById(R.id.emailLogin);
        this.password=findViewById(R.id.passLogin);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Login!", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(LoginActivity.this,UserActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("email",email.getText().toString());
                bundle.putString("password",password.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}