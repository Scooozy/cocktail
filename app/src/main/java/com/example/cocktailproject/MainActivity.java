package com.example.cocktailproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailproject.adapter.AdaptaterFiltre;
import com.example.cocktailproject.adapter.AdaptateurSpinnerFiltres;
import com.example.cocktailproject.adapter.AlcoolicAdapter;
import com.example.cocktailproject.controleurs.ControleurClicFiltre;
import com.example.cocktailproject.model.Cocktails;
import com.example.cocktailproject.model.CocktailsWrapper;
import com.example.cocktailproject.model.Filtre;
import com.example.cocktailproject.web.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Cocktails> cocktailAlcoolicList = new ArrayList<>();
    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<Filtre> filtreAdapter;
        String[] filtres = {"name of drink", "Search by ingredient", "Search an ingredient"};

        gridView = findViewById(R.id.listeCocktails);


        Spinner choixFiltres = findViewById(R.id.choixFiltre);

        AdaptateurSpinnerFiltres adaptateurChoix = new AdaptateurSpinnerFiltres(choixFiltres);
        AdaptaterFiltre adaptateurFiltres = new AdaptaterFiltre(this, adaptateurChoix);


        choixFiltres.setAdapter(adaptateurChoix);
        choixFiltres.setOnItemSelectedListener(new ControleurClicFiltre(adaptateurFiltres, adaptateurChoix));



        Boolean alcohol = getIntent().getExtras().getBoolean("alcohol");
        if (alcohol){
            getAllImageAlcoholic();
        }else{
            getAllImageNonAlcoholic();
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this, CocktailActivity.class)
                    .putExtra("data", cocktailAlcoolicList.get(i).getIdDrink()));
            }
        });




    }
    public void getAllImageAlcoholic(){
        Call<CocktailsWrapper> coctailAlcoolic = ApiClient.getInterface().getAllAlcoholic();
        coctailAlcoolic.enqueue(new Callback<CocktailsWrapper>() {
            @Override
            public void onResponse(Call<CocktailsWrapper> call, Response<CocktailsWrapper> response) {

                if (response.isSuccessful()){
                    String message = "Request successful ...";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();

                    cocktailAlcoolicList = response.body().getDrink();
                    System.out.println(cocktailAlcoolicList);
                    AlcoolicAdapter alcoolicAdapter = new AlcoolicAdapter(cocktailAlcoolicList, MainActivity.this);
                    gridView.setAdapter(alcoolicAdapter);
                }else{
                    String message = "An error occurred try again later ...";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CocktailsWrapper> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }
    public void getAllImageNonAlcoholic(){
        Call<CocktailsWrapper> coctailAlcoolic = ApiClient.getInterface().getAllNonAlcoholic();
        coctailAlcoolic.enqueue(new Callback<CocktailsWrapper>() {
            @Override
            public void onResponse(Call<CocktailsWrapper> call, Response<CocktailsWrapper> response) {

                if (response.isSuccessful()){
                    String message = "Request successful ...";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();

                    cocktailAlcoolicList = response.body().getDrink();
                    System.out.println(cocktailAlcoolicList);

                    AlcoolicAdapter alcoolicAdapter = new AlcoolicAdapter(cocktailAlcoolicList, MainActivity.this);
                    gridView.setAdapter(alcoolicAdapter);
                }else{
                    String message = "An error occurred try again later ...";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CocktailsWrapper> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }

}