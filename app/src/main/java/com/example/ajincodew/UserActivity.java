package com.example.ajincodew;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    private TextView email;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_activity);
        this.email=findViewById(R.id.emailVue);
        this.password=findViewById(R.id.passwordVue);

        Bundle b=getIntent().getExtras();
        email.setText("email: "+b.getString("email"));
        password.setText("password : "+b.getString("password"));
    }
}