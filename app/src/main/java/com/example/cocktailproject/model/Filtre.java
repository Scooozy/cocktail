package com.example.cocktailproject.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public abstract class Filtre {
        final protected String nom_reel;
        final protected int id;

        protected static Map<String, Integer> par_defaut;

        public static Map<String, Integer> par_defaut() {
            if (par_defaut != null) {
                return par_defaut;
            } else {
                par_defaut = new HashMap();
                par_defaut.put("Name of drink", 1);
                par_defaut.put("Search by ingredient", 2);
                par_defaut.put("Give a random drink", 3);
                return par_defaut;
            }
        }
        public String nom() {
            return nom_reel;
        }


        protected Filtre(String nom_reel, int id) {
            this.nom_reel = nom_reel;
            this.id = id;
        }

    }

