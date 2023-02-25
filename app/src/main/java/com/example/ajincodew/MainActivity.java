package com.example.ajincodew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView username;
    TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btn=(Button) findViewById(R.id.login);
        this.username=(TextView) findViewById(R.id.username);
        this.password=(TextView) findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                Bundle b=new Bundle();
                b.putString("username",username.getText().toString());
                b.putString("password",password.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}