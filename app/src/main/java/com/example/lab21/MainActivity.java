                         package com.example.lab21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        countriesList = (ListView) findViewById(R.id.countriesList);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
        countriesList.setAdapter(stateAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(), Toast.LENGTH_SHORT).show();

            }
        };
        countriesList.setOnItemClickListener(itemListener);


    }

    private void setInitialData()
    {
        states.add(new State("Россия", "Москва", R.drawable.ru));
        states.add(new State("США", "Вашингтон", R.drawable.us));
        states.add(new State("Австралия", "Канберра", R.drawable.au));
        states.add(new State("Япония", "Токио", R.drawable.jp));
        states.add(new State("Вьетнам", "Ханой", R.drawable.vn));
    }
}