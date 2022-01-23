package com.example.cocktailproject.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Filtre<T> {
    final protected String nom_reel;
    final protected String nom_url;

    protected static Map<String, FiltreModifiable<?>> par_defaut;

    protected T valeur;

    /**
     * Renvoie sept filtres.
     * @return Une map nom_du_filtre -> filtre. Cette map et ses éléments sont toujours les mêmes.
     */
    public static Map<String, FiltreModifiable<?>> par_defaut() {
        if (par_defaut == null) {
            par_defaut = new HashMap<>();
            par_defaut = new HashMap<>();
            par_defaut.put("Name", new FiltreLitteral("Name", "cocktail_name"));
            par_defaut.put("Ingredient", new FiltreNumerique("Ingredient", "ingredient"));
            par_defaut.put("Random", new FiltreNumerique("Random", "random"));
        }
        return par_defaut;
    }

    /**
     * Renvoie le nom réel du filtre.
     */
    public String nom() {
        return nom_reel;
    }

    /**
     * Renvoie une chaîne pouvant être intégrée à une url.
     */
    public String url() {
        return nom_url + "=" + texte();
    }

    /**
     * Renvoie la valeur.
     *
     * @return une chaîne de caractères.
     */
    public String texte() {
        return String.valueOf(valeur);
    }

    /**
     * Renvoie le type supporté par le filtre.
     *
     * @return 1 pour un littéral, 2 pour un numérique.
     */
    public abstract int type();

    /**
     * Vérifie si la valeur actuelle du filtre est valide.
     *
     * @return true si la valeure est valide.
     */
    public abstract boolean estValide();

    /**
     * Crée un filtre.
     *
     * @param nom_reel le nom du filtre en français
     * @param nom_url le nom du filtre à utiliser dans l’URL
     */
    protected Filtre(String nom_reel, String nom_url) {
        this.nom_reel = nom_reel;
        this.nom_url = nom_url;
    }

    @Override
    public int hashCode() {
        return nom_url.hashCode();
    }
}

