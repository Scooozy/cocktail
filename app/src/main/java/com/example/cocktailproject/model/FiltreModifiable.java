package com.example.cocktailproject.model;

/**
 * Un filtre dont on peut directement modifier la valeur.
 */
public abstract class FiltreModifiable<T> extends Filtre<T> {
    /**
     * Change la valeur du filtre.
     *
     * @param valeur la nouvelle valeur
     * @return true si la nouvelle valeur est valide, false si le format est incorrect
     */
    public abstract boolean changerValeur(String valeur);

    /**
     * Crée un filtre.
     *
     * @param nom_reel le nom du filtre en français
     * @param nom_url  le nom du filtre à utiliser dans l’URL
     */
    protected FiltreModifiable(String nom_reel, String nom_url) {
        super(nom_reel, nom_url);
    }
}
