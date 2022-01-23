package com.example.cocktailproject.model;

public class FiltreNombreResultats extends FiltreNumerique {
    public static final int VALEUR_MIN = 0;
    public static final int VALEUR_PAR_DEFAUT = 10;
    public static final int VALEUR_MAX = 25;

    public FiltreNombreResultats() {
        super("Nombre de résultats", "per_page");
        valeur = VALEUR_PAR_DEFAUT;
    }

    @Override
    public boolean estValide() {
        return valeur >= 0 && valeur <= VALEUR_MAX;
    }
}
