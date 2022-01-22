package com.example.cocktailproject.controleurs;

import android.view.View;
import android.widget.AdapterView;

import com.example.cocktailproject.adapter.AdaptaterFiltre;
import com.example.cocktailproject.adapter.AdaptateurSpinnerFiltres;
import com.example.cocktailproject.model.Filtre;

import java.util.Map;

public class ControleurClicFiltre implements AdapterView.OnItemSelectedListener {
    protected final AdaptaterFiltre adaptateurFiltres;
    protected final AdaptateurSpinnerFiltres adaptateurSpinnerFiltres;

    public ControleurClicFiltre(AdaptaterFiltre adaptateurFiltres, AdaptateurSpinnerFiltres adaptateurSpinnerFiltres) {
        this.adaptateurFiltres = adaptateurFiltres;
        this.adaptateurSpinnerFiltres = adaptateurSpinnerFiltres;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String nom_filtre = String.valueOf(parent.getItemAtPosition(position));
        Map<String, Integer> filtres = Filtre.par_defaut();

        if (filtres.containsKey(nom_filtre)) {
            
            //Filtre filtre = filtres.get(position);

            //adaptateurFiltres.add(filtre);
            adaptateurSpinnerFiltres.remove(nom_filtre);
            parent.setSelection(0);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
