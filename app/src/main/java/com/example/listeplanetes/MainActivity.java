package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected ArrayList<String> planetes;
    Data data = new Data();


    ListView listview;
    PlaneteAdapter adapter;

    // Initialise la liste
    private void installePlanetes() {
        planetes = new ArrayList<String>();

        for (String pl: data.getNomPlanetes()) {
            planetes.add(pl);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        installePlanetes();

        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter(this);
        listview.setAdapter(adapter);


    }

}