package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntroActivity extends AppCompatActivity {

    Handler h = new Handler();
    Runnable r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);

        final String start1 = sp.getString("m_name","");

        h.postDelayed(r = new Runnable() {
            @Override
            public void run() {
                if(start1 == "") {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), TitleActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2000);
    }
}
