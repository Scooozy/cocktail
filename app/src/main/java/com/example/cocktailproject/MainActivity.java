package com.example.cocktailproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailproject.adapter.AlcoolicAdapter;
import com.example.cocktailproject.model.Cocktails;
import com.example.cocktailproject.model.CocktailsWrapper;
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
        View view = findViewById(R.id.main);
        gridView = findViewById(R.id.listeCocktails);

        Boolean canon = getIntent().getExtras().getBoolean("canon");
        if (canon){
            view.setBackgroundColor(Color.rgb( 80, 10, 2));
        }else{

            view.setBackgroundColor(Color.rgb( 2, 10, 80));
            getAllImageAlcoolic();
        }




    }
    public void getAllImageAlcoolic(){
        Call<CocktailsWrapper> coctailAlcoolic = ApiClient.getInterface().getAllCocktails();
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