package com.example.cocktailproject.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public abstract class Filtre {
        final protected String nom_reel;
        final protected int id;

        protected static Map<String, Integer> par_defaut;

        /**
         * Renvoie sept filtres.
         * @return Une map nom_du_filtre -> filtre. Cette map et ses éléments sont toujours les mêmes.
         */
        public static Map<String, Integer> par_defaut() {
            if (par_defaut != null) {
                return par_defaut;
            } else {
                par_defaut = new HashMap();
                par_defaut.put("Name of drink", 1);
                par_defaut.put("Search by ingredient", 2);
                par_defaut.put("Search an ingredient", 3);
                return par_defaut;
            }
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
        public abstract String url();

        /**
         * Renvoie la valeur
         *
         * @return une chaîne de caractères.
         */
        public abstract String texte();

        /**
         * Change la valeur du filtre.
         *
         * @param valeur la nouvelle valeur
         * @return true si la nouvelle valeur est valide, false si le format est incorrect
         */
        public abstract boolean changerValeur(String valeur);

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
         * @param id le nom du filtre à utiliser dans l’URL
         */
        protected Filtre(String nom_reel, int id) {
            this.nom_reel = nom_reel;
            this.id = id;
        }

    }

