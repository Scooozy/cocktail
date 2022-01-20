package com.example.starwarsproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.starwarsproject.model.People;

public class PersoActivity extends AppCompatActivity {
    ImageView imagePerso;
    Button incarner;

    TextView nomPre;
    TextView genre;
    TextView date;
    TextView espece;
    TextView apparitions;
    TextView wiki;
    TextView taille;
    TextView masse;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso);

        //Declaration des champs
        imagePerso  = findViewById(R.id.imgPerso);
        incarner    = findViewById(R.id.Incarner);
        nomPre      = findViewById(R.id.NomPrenom);
        genre       = findViewById(R.id.GenreRep);
        date        = findViewById(R.id.NaissanceRep);
        espece      = findViewById(R.id.EspeceRep);
        apparitions = findViewById(R.id.ApparitionsRep);
        wiki        = findViewById(R.id.WikiRep);
        taille      = findViewById(R.id.TailleRep);
        masse       = findViewById(R.id.MasseRep);

        //attribution des valeurs
        People personnage = getIntent().getParcelableExtra("perso");

        nomPre.setText(personnage.getName());
        genre.setText(personnage.getGender());
        date.setText(personnage.getDateNaissance());
        espece.setText(personnage.getSpecies());
        apparitions.setText(personnage.getApparitions());
        wiki.setText(personnage.getWikiLien());
        taille.setText(personnage.getHeight());
        masse.setText(personnage.getMass());

        //attribution des listeners
        incarner.setOnClickListener(v -> {
            Intent intent = new Intent(PersoActivity.this, MainActivity.class);
            intent.putExtra("persoIncarne", personnage.getImage());
        });
    }
}
