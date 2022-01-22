package com.example.cocktailproject.web;

import com.example.cocktailproject.model.People;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("all.json")
    Call<List<People>> getAllImages();

    @GET("people/")
    Call<List<People>> getAllPeople();
}
