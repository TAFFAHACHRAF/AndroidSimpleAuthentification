package com.example.ajincodew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();

                try {
                    saveUser();
                    Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void saveUser() throws IOException {
            String data=this.username+","+this.email+","+this.password+";\n";
            OutputStream outputStream = null;
            try {
                outputStream = openFileOutput("db.txt", Context.MODE_APPEND);
                outputStream.write(data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}