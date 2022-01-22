package com.example.cocktailproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    ImageButton canon;
    ImageButton legends;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        canon = findViewById(R.id.alcoholic);
        legends = findViewById(R.id.nonAlcoholic);

        canon.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
            intent.putExtra("canon", true);

            startActivity(intent);
        });

        legends.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
            intent.putExtra("canon", false);

            startActivity(intent);
        });
    }
}
