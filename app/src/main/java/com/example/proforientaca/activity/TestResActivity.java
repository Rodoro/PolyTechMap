package com.example.proforientaca.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proforientaca.R;

public class TestResActivity extends AppCompatActivity {

    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_res);

        resultText = findViewById(R.id.resultView);
        resultText.setText(getIntent().getExtras().getString("result"));
    }

    public void bHome(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}