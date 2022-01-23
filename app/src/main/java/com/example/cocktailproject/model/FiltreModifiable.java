package com.example.cocktailproject.model;

public abstract class FiltreModifiable<T> extends Filtre<T> {

    public abstract boolean changerValeur(String valeur);


    protected FiltreModifiable(String nom_reel, String nom_url) {
        super(nom_reel, nom_url);
    }
}
