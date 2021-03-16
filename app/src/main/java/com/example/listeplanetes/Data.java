package com.example.listeplanetes;

import java.util.ArrayList;

public class Data {


    private ArrayList<String> planetes_name;
    private String[] planetes_size = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

    public Data() {
        installePlanetes();
    }

    public String[] getPlanetesSize() {
        return planetes_size;
    }


    public ArrayList<String> getPlanetesName() {
        return planetes_name;
    }


    private void installePlanetes() {
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
    }

}
