package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> planetes;
    Data data;


    ListView listview;
    PlaneteAdapter adapter;
    Button verifyButton;


    private static final String TAG = "MyActivity";


    // Initialise la liste
   /* private void installePlanetes() {
        planetes_name = new ArrayList<String>();
        planetes_name.add("Mercure");
        planetes_name.add("Venus");
        planetes_name.add("Terre");
        planetes_name.add("Mars");
        planetes_name.add("Jupiter");
        planetes_name.add("Saturne");
        planetes_name.add("Uranus");
        planetes_name.add("Neptune");
        planetes_name.add("Pluton");
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data  = new Data();

        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter(this, data.getPlanetesName());
        listview.setAdapter(adapter);


        // Vertify Button
        verifyButton = (Button) findViewById(R.id.verifyButton);
        verifyButton.setOnClickListener(verifyListener);

    }


    private View.OnClickListener verifyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < data.getPlanetesName().size(); i++) {
                View item = (View) listview.getChildAt(i);
                Spinner sp = (Spinner) item.findViewById(R.id.spinner);

                if (!sp.getSelectedItem().toString().equals(data.getPlanetesSize()[i])) {
                    popUp(sp.getSelectedItem().toString() + " doit etre : " + data.getPlanetesSize()[i] + "Vous n'avez pas les bonnes propositions");
                    return;
                }
            }
            popUp("Bien joué ! Vous avez les bons résultats");
        }
    };


    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}