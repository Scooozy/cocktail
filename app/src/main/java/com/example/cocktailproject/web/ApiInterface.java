package com.example.cocktailproject.web;

import com.example.cocktailproject.model.CocktailWrapper;
import com.example.cocktailproject.model.Cocktails;
import com.example.cocktailproject.model.CocktailsWrapper;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("filter.php?a=Alcoholic")
    Call<CocktailsWrapper> getAllAlcoholic();
    @GET("filter.php?a=Non_Alcoholic")
    Call<CocktailsWrapper> getAllNonAlcoholic();
    @GET("lookup.php?")
    Call<CocktailWrapper> getDrinkById(@Query("i") String idDrink);

}
