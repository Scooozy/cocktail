package com.example.cocktailproject.controleurs;

import android.view.View;

import com.example.cocktailproject.adapter.AdaptaterFiltre;
import com.example.cocktailproject.adapter.AdaptateurSpinnerFiltres;
import com.example.cocktailproject.model.Filtre;

public class ControleurClicSupprimer extends Controleur implements View.OnClickListener {
    protected final Filtre filtre;
    protected final AdaptaterFiltre adaptateurFiltres;
    protected final AdaptateurSpinnerFiltres adaptateurSpinnerFiltres;

    public ControleurClicSupprimer(Filtre filtre, AdaptaterFiltre adaptateurFiltres, AdaptateurSpinnerFiltres adaptateurSpinnerFiltres) {
        this.filtre = filtre;
        this.adaptateurFiltres = adaptateurFiltres;
        this.adaptateurSpinnerFiltres = adaptateurSpinnerFiltres;
    }

    @Override
    public void onClick(View v) {
        cacherClavier(v);
        adaptateurFiltres.remove(filtre);
        adaptateurSpinnerFiltres.add(filtre.nom());
    }
}
