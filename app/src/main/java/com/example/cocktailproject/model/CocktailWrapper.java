package com.example.cocktailproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CocktailWrapper {

    @SerializedName("drinks")
    @Expose
    private List<Cocktail> drinkName;
    public List<Cocktail> getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(List<Cocktail> drinkName) {
        this.drinkName = drinkName;
    }

}
