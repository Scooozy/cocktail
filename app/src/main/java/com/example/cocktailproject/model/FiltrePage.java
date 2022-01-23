package com.example.cocktailproject.model;

import android.text.InputType;

/**
 * Un filtre qui définit la page à afficher.
 */
public class FiltrePage extends Filtre<Integer> {
    public static final int PREMIERE_PAGE = 1;

    /**
     * Crée un filtre définissant la page à afficher.
     */
    public FiltrePage() {
        super("Page", "page");
        valeur = PREMIERE_PAGE;
    }

    /**
     * Renvoie la valeur du filtre.
     * @return un entier.
     */
    public int valeur() {
        return valeur;
    }

    /**
     * Retour à la première page.
     */
    public void reinitialiser() {
        valeur = PREMIERE_PAGE;
    }

    /**
     * Passe à la page précédente.
     */
    public void precedente() {
        valeur--;
    }

    /**
     * Passe à la page précédente.
     */
    public void suivante() {
        valeur++;
    }

    @Override
    public int type() {
        return InputType.TYPE_CLASS_NUMBER;
    }

    @Override
    public boolean estValide() {
        return valeur >= PREMIERE_PAGE;
    }
}
