package com.example.cocktailproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailproject.adapter.AdaptateurFiltre;
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
    GridView gridView;
    private List<Cocktails> cocktailAlcoolicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.listeCocktails);
        Spinner choixFiltres = findViewById(R.id.choixFiltre);
        ListView listeFiltres = findViewById(R.id.listeFiltres);


        AdaptateurSpinnerFiltres adaptateurChoix = new AdaptateurSpinnerFiltres(choixFiltres);
        AdaptateurFiltre adaptateurFiltres = new AdaptateurFiltre(this, adaptateurChoix);

        listeFiltres.setAdapter(adaptateurFiltres);
        choixFiltres.setAdapter(adaptateurChoix);
        choixFiltres.setOnItemSelectedListener(new ControleurClicFiltre(adaptateurFiltres, adaptateurChoix));

        Button search = findViewById(R.id.rechercher);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filtre filtre;
                for (int i = 0; i< adaptateurFiltres.getCount(); i++){
                    filtre = adaptateurFiltres.getItem(i);

                    if (filtre.nom() == "Name"){
                        getByName(filtre.texte());
                    }else if (filtre.nom() == "Ingredient"){
                        getByIngredient(filtre.texte());
                    }else if (filtre.nom() == "Random"){
                        getRandom();
                    }
                }
            }
        });

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

    public void getByName(String texte){
        Call<CocktailsWrapper> coctailAlcoolic = ApiClient.getInterface().getByName(texte);
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

    public void getByIngredient(String texte){
        Call<CocktailsWrapper> coctailAlcoolic = ApiClient.getInterface().getByIngredient(texte);
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

    public void getRandom(){
        Call<CocktailsWrapper> coctailAlcoolic = ApiClient.getInterface().getARandom();
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