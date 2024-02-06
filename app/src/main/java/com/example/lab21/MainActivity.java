package com.example.lab21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView countriesList = (RecyclerView) findViewById(R.id.CountryList);
        ArrayList<State> states = new ArrayList();
        states.add(new State("Россия", "Москва", R.drawable.ru));
        states.add(new State("США", "Вашингтон", R.drawable.us));
        states.add(new State("Австралия", "Канберра", R.drawable.au));
        states.add(new State("Япония", "Токио", R.drawable.jp));
        states.add(new State("Вьетнам", "Ханой", R.drawable.vn));
        StateAdapter stateAdapter = new StateAdapter(states);
        countriesList.setAdapter(stateAdapter);
        stateAdapter.setOnItemClickListener(new StateAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(State state) {
                Toast.makeText(MainActivity.this, "Был выбран пункт " + state.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        countriesList.setLayoutManager(new LinearLayoutManager(this));


    }

}