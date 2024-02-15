package com.example.proforientaca.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import com.example.proforientaca.R;
import com.example.proforientaca.activity.polytech.Polytech8Activity;
import com.example.proforientaca.models.Polytech;

import java.util.ArrayList;

public class ListPolytechsActivity extends AppCompatActivity {
    ArrayList<Polytech> polytechs = new ArrayList<Polytech>();
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_polytechs);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Polytech state, int position) {
                startActivity(new Intent(ListPolytechsActivity.this, state.getActivity()));
            }
        };
        StateAdapter adapter = new StateAdapter(this, polytechs,stateClickListener );
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){
        polytechs.add(new Polytech(Polytech8Activity.class,"Колледж №8" , "Должно быть но хз где", R.drawable.logo_8, "1-й Боткинский проезд, дом 7А", "https://pk-8.mskobr.ru/", "+7 (495) 640-60-58"));
        polytechs.add(new Polytech(Polytech8Activity.class,"Колледж №13", "Должно быть но хз где", R.drawable.logo_13, "ул. Бибиревская, д. 6, корп. 1", "https://spo-13.mskobr.ru/", "+7 (499) 901-87-81"));
        polytechs.add(new Polytech(Polytech8Activity.class,"Колледж №18", "Должно быть но хз где", R.drawable.logo_18, "Митинская улица, дом 45, корпус 3", "https://pk18.mskobr.ru/", "+7 (495) 751-90-04"));
        polytechs.add(new Polytech(Polytech8Activity.class,"Колледж №47", "Должно быть но хз где", R.drawable.logo_47, "Волоколамское ш., д. 112, корп. 3", "https://politech47.mskobr.ru/", "+7 (495) 491-65-10"));
    }
}