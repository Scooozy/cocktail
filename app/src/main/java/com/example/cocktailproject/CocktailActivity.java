package com.example.cocktailproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CocktailActivity extends AppCompatActivity {
    ImageView image;

    TextView nom;
    TextView date_abv;
    TextView description;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        //Declaration des champs
        image = findViewById(R.id.image);
        nom = findViewById(R.id.nom);
        date_abv = findViewById(R.id.date_abv);
        description = findViewById(R.id.description);

        //attribution des valeurs
        //People personnage = getIntent().getParcelableExtra("perso");

        /*nom.setText(personnage.getName());
        date_abv.setText(personnage.getGender());
        description.setText(personnage.getDateNaissance());*/

    }
}
