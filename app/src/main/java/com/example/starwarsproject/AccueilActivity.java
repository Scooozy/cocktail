package com.example.starwarsproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    ImageButton darkSide;
    ImageButton lightSide;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        darkSide = findViewById(R.id.darkSide);
        lightSide = findViewById(R.id.lightSide);


        darkSide.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
            intent.putExtra("forceSide", true);

            startActivity(intent);
        });

        lightSide.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
            intent.putExtra("forceSide", false);

            startActivity(intent);
        });
    }
}
