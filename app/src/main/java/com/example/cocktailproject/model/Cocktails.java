package com.example.cocktailproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cocktails {
    @SerializedName("strDrink")
    @Expose
    String strDrink;
    @SerializedName("strDrinkThumb")
    @Expose
    String strDrinkThumb;
    @SerializedName("idDrink")
    @Expose
    String idDrink;

    public Cocktails(String strDrink, String strDrinkThumb, String idDrink) {
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = idDrink;
    }

    public Cocktails() {
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    @Override
    public String toString() {
        return "cocktails{" +
                "strDrink='" + strDrink + '\'' +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                ", idDrink='" + idDrink + '\'' +
                '}';
    }
}