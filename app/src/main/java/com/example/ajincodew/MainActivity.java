package com.example.ajincodew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
                if(userExist(username.getText().toString(),password.getText().toString())==true) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle b = new Bundle();
                    b.putString("username", username.getText().toString());
                    b.putString("password", password.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Login or password is not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean userExist(String username,String password){
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("db.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            List<String> infos=new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                infos.add(line);
            }
            bufferedReader.close();
            return (infos.get(0).compareTo(username)==0 && infos.get(1).compareTo(password)==0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}