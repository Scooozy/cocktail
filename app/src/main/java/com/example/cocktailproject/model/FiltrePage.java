package com.example.cocktailproject.model;

import android.text.InputType;


public class FiltrePage extends Filtre<Integer> {
    public static final int PREMIERE_PAGE = 1;


    public FiltrePage() {
        super("Page", "page");
        valeur = PREMIERE_PAGE;
    }

    public int valeur() {
        return valeur;
    }

    public void reinitialiser() {
        valeur = PREMIERE_PAGE;
    }

    public void precedente() {
        valeur--;
    }

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
