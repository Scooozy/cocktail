package com.example.cocktailproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailproject.model.Cocktail;
import com.example.cocktailproject.model.CocktailWrapper;
import com.example.cocktailproject.web.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CocktailActivity extends AppCompatActivity {
    Cocktail cocktail;
    private List<Cocktail> valueCocktail = new ArrayList<>();
    String idCocktail;
    ImageView image;

    TextView nom;
    TextView date_abv;
    TextView description;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        Intent intent = getIntent();

        if (intent.getExtras() != null){
            idCocktail = intent.getStringExtra("data");
            getDrink();
        }


        image = findViewById(R.id.image);
        nom = findViewById(R.id.nom);
        date_abv = findViewById(R.id.date_abv);
        description = findViewById(R.id.description);



    }

    public void getDrink(){
        Call<CocktailWrapper> drink = ApiClient.getInterface().getDrinkById(idCocktail);
        drink.enqueue(new Callback<CocktailWrapper>() {
            @Override
            public void onResponse(Call<CocktailWrapper> call, Response<CocktailWrapper> response) {

                if (response.isSuccessful()){


                    valueCocktail = response.body().getDrinkName();
                    System.out.println(valueCocktail);
                }
            }

            @Override
            public void onFailure(Call<CocktailWrapper> call, Throwable t) {


            }
        });    }
}
