package com.example.starwarsproject.web;

import com.example.starwarsproject.model.People;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("all.json")
    Call<List<People>> getAllImages();
}
