package com.example.cocktailproject.model;

import android.text.InputType;


public class FiltreNumerique extends FiltreModifiable<Integer> {

    protected FiltreNumerique(String nom_reel, String nom_url) {
        super(nom_reel, nom_url);
        valeur = 0;
    }

    @Override
    public boolean changerValeur(String valeur) {
        try {
            this.valeur = Integer.parseInt(valeur);
            return true;
        } catch (NumberFormatException exception) {
            this.valeur = 0;
            return false;
        }
    }

    public int valeur() {
        return valeur;
    }

    public boolean changerValeur(int valeur) {
        this.valeur = valeur;
        return true;
    }

    @Override
    public int type() {
        return InputType.TYPE_CLASS_NUMBER;
    }

    @Override
    public boolean estValide() {
        return true;
    }
}
