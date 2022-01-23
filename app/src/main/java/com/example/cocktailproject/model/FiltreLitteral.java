package com.example.cocktailproject.model;

import android.text.InputType;

/**
 * Un filtre dont la valeur est une chaîne.
 */
public class FiltreLitteral extends FiltreModifiable<String> {
    /**
     * Crée un filtre.
     *
     * @param nom_reel le nom du filtre en français.
     * @param nom_url  le nom du filtre à utiliser dans l’URL.
     */
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
