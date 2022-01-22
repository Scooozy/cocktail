package com.example.cocktailproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.cocktailproject.model.Cocktail;

public class CocktailActivity extends AppCompatActivity {
    ImageView image;

    TextView nom;
    TextView Id;
    TextView instruction;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        //Declaration des champs
        image = findViewById(R.id.image);
        nom = findViewById(R.id.nom);
        Id = findViewById(R.id.date_abv);
        instruction = findViewById(R.id.description);

        //attribution des valeurs
        Cocktail cocktail = getIntent().getParcelableExtra("perso");

        Glide.with(this).load(cocktail.getimgURL()).into(image);
        nom.setText(cocktail.getName());
        Id.setText(cocktail.getId());
        instruction.setText(cocktail.getInstructions());
    }
}
