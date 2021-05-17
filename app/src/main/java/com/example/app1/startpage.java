package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class startpage extends AppCompatActivity {

    ImageView loginback;
    Button button, creataccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        loginback = findViewById(R.id.login_back_button);
        button = findViewById(R.id.letTheUserLogIn);
        creataccount = findViewById(R.id.creataccount);


        creataccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startpage.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startpage.this, Onbord.class);
                startActivity(intent);
                finish();
            }
        });

        loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startpage.this, Onbord.class);
                startActivity(intent);
                finish();
            }
        });
    }
}