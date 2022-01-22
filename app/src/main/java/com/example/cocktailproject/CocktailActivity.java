package com.example.cocktailproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cocktailproject.glide.GlideApp;
import com.example.cocktailproject.model.Cocktail;
import com.example.cocktailproject.model.CocktailWrapper;
import com.example.cocktailproject.web.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CocktailActivity extends AppCompatActivity {
    private List<Cocktail> valueCocktail = new ArrayList<>();
    String idCocktail;
    ImageView image;

    TextView nom;
    TextView description;

    TextView strIngredient1, strMeasure1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        Intent intent = getIntent();
        image = findViewById(R.id.image);
        nom = findViewById(R.id.nom);
        description = findViewById(R.id.description);
        strIngredient1 = findViewById(R.id.textView2);
        strMeasure1 = findViewById(R.id.textView4);


        if (intent.getExtras() != null){
            idCocktail = intent.getStringExtra("data");
            Call<CocktailWrapper> drink = ApiClient.getInterface().getDrinkById(idCocktail);
            drink.enqueue(new Callback<CocktailWrapper>() {
                @Override
                public void onResponse(Call<CocktailWrapper> call, Response<CocktailWrapper> response) {

                    if (response.isSuccessful()){


                        valueCocktail = response.body().getDrinkName();

                        System.out.println("donnees"+valueCocktail.get(0).getStrDrink());

                        GlideApp.with(CocktailActivity.this).load(valueCocktail.get(0).getStrDrinkThumb()).into(image);
                        nom.setText(valueCocktail.get(0).getStrDrink());
                        description.setText(valueCocktail.get(0).getStrInstructions());

                        if (valueCocktail.get(0).getStrIngredient1() != null){
                            if (valueCocktail.get(0).getStrIngredient2() != null){
                                if (valueCocktail.get(0).getStrIngredient3() != null){
                                    if (valueCocktail.get(0).getStrIngredient4() != null){
                                        if (valueCocktail.get(0).getStrIngredient5() != null){
                                            strIngredient1.setText(valueCocktail.get(0).getStrIngredient1()+", "+valueCocktail.get(0).getStrIngredient2()+", "+valueCocktail.get(0).getStrIngredient3()+
                                                    ", "+valueCocktail.get(0).getStrIngredient4()+", "+valueCocktail.get(0).getStrIngredient5());
                                        }else{
                                            strIngredient1.setText(valueCocktail.get(0).getStrIngredient1()+", "+valueCocktail.get(0).getStrIngredient2()+", "+valueCocktail.get(0).getStrIngredient3()+
                                                    ", "+valueCocktail.get(0).getStrIngredient4());
                                        }
                                    }else{
                                        strIngredient1.setText(valueCocktail.get(0).getStrIngredient1()+", "+valueCocktail.get(0).getStrIngredient2()+", "+valueCocktail.get(0).getStrIngredient3());

                                    }
                                }else{
                                    strIngredient1.setText(valueCocktail.get(0).getStrIngredient1()+", "+valueCocktail.get(0).getStrIngredient2());
                                }
                            }else{
                                strIngredient1.setText(valueCocktail.get(0).getStrIngredient1());
                            }
                        }
                        if (valueCocktail.get(0).getStrMeasure1() != null){
                            if (valueCocktail.get(0).getStrMeasure2() != null){
                                if (valueCocktail.get(0).getStrMeasure3() != null){
                                    if (valueCocktail.get(0).getStrMeasure4() != null){
                                        if (valueCocktail.get(0).getStrMeasure5() != null){
                                            strMeasure1.setText(valueCocktail.get(0).getStrMeasure1()+", "+valueCocktail.get(0).getStrMeasure2()+", "+valueCocktail.get(0).getStrMeasure3()+
                                                    ", "+valueCocktail.get(0).getStrMeasure4()+", "+valueCocktail.get(0).getStrMeasure5());
                                        }else{
                                            strMeasure1.setText(valueCocktail.get(0).getStrMeasure1()+", "+valueCocktail.get(0).getStrMeasure2()+", "+valueCocktail.get(0).getStrMeasure3()+
                                                    ", "+valueCocktail.get(0).getStrMeasure4());
                                        }
                                    }else{
                                        strMeasure1.setText(valueCocktail.get(0).getStrMeasure1()+", "+valueCocktail.get(0).getStrMeasure2()+", "+valueCocktail.get(0).getStrMeasure3());

                                    }
                                }else{
                                    strMeasure1.setText(valueCocktail.get(0).getStrMeasure1()+", "+valueCocktail.get(0).getStrMeasure2());
                                }
                            }else{
                                strMeasure1.setText(valueCocktail.get(0).getStrMeasure1());
                            }
                        }



                    }
                }

                @Override
                public void onFailure(Call<CocktailWrapper> call, Throwable t) {


                }
            });

        }






    }

}
