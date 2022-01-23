package com.example.cocktailproject.model;

import android.text.InputType;


public class FiltreLitteral extends FiltreModifiable<String> {

    protected FiltreLitteral(String nom_reel, String nom_url) {
        super(nom_reel, nom_url);
        valeur = "";
    }

    @Override
    public boolean changerValeur(String valeur) {
        this.valeur = valeur;
        return estValide();
    }

    @Override
    public int type() {
        return InputType.TYPE_CLASS_TEXT;
    }

    @Override
    public boolean estValide() {
        return !(valeur.trim().isEmpty());
    }
}
