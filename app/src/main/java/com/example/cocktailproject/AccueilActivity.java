package com.example.cocktailproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    ImageButton alcohol;
    ImageButton nonAlcohol;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        alcohol = findViewById(R.id.alcoholic);
        nonAlcohol = findViewById(R.id.nonAlcoholic);

        alcohol.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
            intent.putExtra("alcohol", true);

            startActivity(intent);
        });

        nonAlcohol.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
            intent.putExtra("alcohol", false);

            startActivity(intent);
        });
    }
}
