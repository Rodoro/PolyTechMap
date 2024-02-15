package com.example.proforientaca.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proforientaca.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bListPolytech(View view){
        startActivity(new Intent(MainActivity.this, ListPolytechsActivity.class));
    }

    public void bTest(View view){
        startActivity(new Intent(MainActivity.this, TestActivity.class));
    }
}