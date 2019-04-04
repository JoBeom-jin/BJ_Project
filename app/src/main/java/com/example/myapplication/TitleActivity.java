package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TitleActivity extends AppCompatActivity {

    TextView t_name;
    TextView t_phone;
    TextView t_gender;
    Button t_button;
    Button menu_bt1;
    Button menu_bt2;
    Button home_bt2;
    Button menu_bt5;


    View.OnClickListener t_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.clear();
            ed.commit();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }
    };


    View.OnClickListener menu1_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(i);
            finish();
        }
    };


    View.OnClickListener menu2_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), MapActivity.class);
            startActivity(i);
            finish();
        }
    };

    View.OnClickListener home_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), TitleActivity.class);
            startActivity(i);
            finish();
        }
    };

    View.OnClickListener menu5_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), MyActivity.class);
            startActivity(i);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);


        t_name = (TextView) findViewById(R.id.t_name);
        t_phone = (TextView) findViewById(R.id.t_phone);
        t_gender = (TextView) findViewById(R.id.t_gender);
        t_button = (Button)findViewById(R.id.t_button);
        menu_bt1 = (Button) findViewById(R.id.menu_bt1);
        menu_bt2 = (Button) findViewById(R.id.menu_bt2);
        home_bt2 = (Button) findViewById(R.id.menu_bt3);
        menu_bt5 = (Button) findViewById(R.id.menu_bt5);

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        String nnn = sp.getString("m_name","");

        Toast.makeText(getApplicationContext(), nnn+"님 환영합니다.",Toast.LENGTH_SHORT).show();

        t_button.setOnClickListener(t_click);
        menu_bt1.setOnClickListener(menu1_click);
        menu_bt2.setOnClickListener(menu2_click);
        home_bt2.setOnClickListener(home_click);
        menu_bt5.setOnClickListener(menu5_click);

        t_name.setText(sp.getString("m_name",""));
        t_phone.setText(sp.getString("m_phone",""));
        t_gender.setText(sp.getString("m_gender",""));
    }
}
