package com.example.ajincodew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView username;
    TextView password;
    Button homme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.username=findViewById(R.id.username);
        this.password=findViewById(R.id.password);
        this.homme=findViewById(R.id.homme);

        Bundle b=getIntent().getExtras();
        username.setText(username.getText().toString()+" "+b.getString("username"));
        password.setText(password.getText().toString()+" "+b.getString("password"));

        homme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}