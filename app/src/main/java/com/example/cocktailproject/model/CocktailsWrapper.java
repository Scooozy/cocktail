package com.example.cocktailproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CocktailsWrapper {
    @SerializedName("contacts")
    @Expose
    private List<Cocktails> drink = null;

    public List<Cocktails> getDrink() {
        return drink;
    }

    public void setDrink(List<Cocktails> drink) {
        this.drink = drink;
    }
}
