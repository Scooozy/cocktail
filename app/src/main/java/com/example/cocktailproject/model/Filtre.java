package com.example.cocktailproject.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Filtre<T> {
    final protected String nom_reel;
    final protected String nom_url;

    protected static Map<String, FiltreModifiable<?>> par_defaut;

    protected T valeur;


    public static Map<String, FiltreModifiable<?>> par_defaut() {
        if (par_defaut == null) {
            par_defaut = new HashMap<>();
            par_defaut = new HashMap<>();
            par_defaut.put("Name", new FiltreLitteral("Name", "cocktail_name"));
            par_defaut.put("Ingredient", new FiltreLitteral("Ingredient", "ingredient"));
            par_defaut.put("Random", new FiltreLitteral("Random", "random"));
        }
        return par_defaut;
    }

    public String nom() {
        return nom_reel;
    }


    public String url() {
        return nom_url + "=" + texte();
    }

    public String texte() {
        return String.valueOf(valeur);
    }

    public abstract int type();


    public abstract boolean estValide();

    protected Filtre(String nom_reel, String nom_url) {
        this.nom_reel = nom_reel;
        this.nom_url = nom_url;
    }

    @Override
    public int hashCode() {
        return nom_url.hashCode();
    }
}

