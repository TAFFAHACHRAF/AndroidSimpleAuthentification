package com.example.ajincodew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GetStartedActivity extends AppCompatActivity {
    Button started;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started);

        this.started=findViewById(R.id.getstarted);

        this.started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GetStartedActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(GetStartedActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}