package com.example.cocktailproject.model;

import android.text.InputType;

/**
 * Un filtre dont la valeur est un entier.
 */
public class FiltreNumerique extends FiltreModifiable<Integer> {
    /**
     * Crée un filtre.
     *
     * @param nom_reel le nom du filtre en français
     * @param nom_url  le nom du filtre à utiliser dans l’URL
     */
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

    /**
     * Renvoie la valeur du filtre.
     * @return un entier.
     */
    public int valeur() {
        return valeur;
    }

    /**
     * Change la valeur du filtre.
     *
     * @param valeur la nouvelle valeur
     * @return true si la nouvelle valeur est valide, false si le format est incorrect
     */
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
