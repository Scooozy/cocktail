package com.example.cocktailproject.controleurs;

import android.view.View;
import android.widget.AdapterView;

import com.example.cocktailproject.adapter.AdaptateurFiltre;
import com.example.cocktailproject.adapter.AdaptateurSpinnerFiltres;
import com.example.cocktailproject.model.Filtre;
import com.example.cocktailproject.model.FiltreModifiable;

import java.util.Map;

/**
 * Contrôleur de clic sur un filtre dans un spinner. Au clic, le filtre est retiré du spinner et
 * ajouté à un ViewGroup.
 */
public class ControleurClicFiltre implements AdapterView.OnItemSelectedListener {
    protected final AdaptateurFiltre adaptateurFiltres;
    protected final AdaptateurSpinnerFiltres adaptateurSpinnerFiltres;

    public ControleurClicFiltre(AdaptateurFiltre adaptateurFiltres, AdaptateurSpinnerFiltres adaptateurSpinnerFiltres) {
        this.adaptateurFiltres = adaptateurFiltres;
        this.adaptateurSpinnerFiltres = adaptateurSpinnerFiltres;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String nom_filtre = (String) parent.getItemAtPosition(position);
        Map<String, FiltreModifiable<?>> filtres = Filtre.par_defaut();

        if (filtres.containsKey(nom_filtre)) {
            adaptateurFiltres.add(filtres.get(nom_filtre));
            adaptateurSpinnerFiltres.remove(nom_filtre);
            parent.setSelection(0);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
