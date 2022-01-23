package com.example.cocktailproject.controleurs;

import android.view.View;

import com.example.cocktailproject.adapter.AdaptateurFiltre;
import com.example.cocktailproject.adapter.AdaptateurSpinnerFiltres;
import com.example.cocktailproject.model.FiltreModifiable;

/**
 * Contrôleur de clic sur le bouton supprimer d’un filtre. Au clic, retire le filtre du Viewgroup et
 * l’ajoute au spinner de sélection.
 */
public class ControleurClicSupprimer extends Controleur implements View.OnClickListener {
    protected final FiltreModifiable<?> filtre;
    protected final AdaptateurFiltre adaptateurFiltres;
    protected final AdaptateurSpinnerFiltres adaptateurSpinnerFiltres;

    public ControleurClicSupprimer(FiltreModifiable<?> filtre, AdaptateurFiltre adaptateurFiltres, AdaptateurSpinnerFiltres adaptateurSpinnerFiltres) {
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
