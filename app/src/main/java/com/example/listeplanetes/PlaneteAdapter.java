package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

// On instantie l'adaptater
class PlaneteAdapter extends BaseAdapter {
    private final MainActivity mainActivity;

    public PlaneteAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return mainActivity.planetes.size();
    }

    @Override
    public Object getItem(int position) {
        return mainActivity.planetes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        // On recupere les items de la liste
        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        // L’objet  nomPlanete va changer le texte de l’element de la liste en le recuperer de la liste des planetes par la position de l’element de la liste
        nomPlanete.setText(mainActivity.planetes.get(position));

        //  installer l'adaptateur pour la liste déroulante (spinner)
        String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_item, taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);


        // On interdit le changement de valeur dans la liste deroulante si la case est cochée
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               /*CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
               if (checkBox.isChecked()) {
                   spinner.setEnabled(false);
                   spinadapter.notifyDataSetChanged();
               } else {
                   spinner.setEnabled(true);
                   spinadapter.notifyDataSetChanged();
               }
*/
                // Une maniere plus simple de l'ecrire
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();

            }
        });


        return itemView;

    }
}
