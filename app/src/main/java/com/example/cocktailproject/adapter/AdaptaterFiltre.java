package com.example.cocktailproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cocktailproject.MainActivity;
import com.example.cocktailproject.R;
import com.example.cocktailproject.controleurs.ControleurClicSupprimer;
import com.example.cocktailproject.model.Filtre;

import java.util.ArrayList;

public class AdaptaterFiltre extends ArrayAdapter<Filtre> {
    protected final LayoutInflater inflater;
    protected final AdaptateurSpinnerFiltres adaptateurSpinner;


    public AdaptaterFiltre(Context context, AdaptateurSpinnerFiltres adaptateurSpinnerFiltres) {
        this(context, new ArrayList<>(), adaptateurSpinnerFiltres);
    }

    public AdaptaterFiltre(Context context, ArrayList<Filtre> filtres, AdaptateurSpinnerFiltres adaptateurSpinnerFiltres) {
        super(context, R.layout.filtre_layout, filtres);
        this.inflater = LayoutInflater.from(context);
        this.adaptateurSpinner = adaptateurSpinnerFiltres;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        AdaptaterFiltre.ViewHolder vh;
        Filtre filtre = getItem(position);
        int tag_filtre = filtre.hashCode();

        if (view == null || view.getTag(tag_filtre) == null) {
            view = inflater.inflate(R.layout.filtre_layout, parent, false);

            vh = new AdaptaterFiltre.ViewHolder();

            vh.nom_filtre = view.findViewById(R.id.nom_filtre);
            vh.valeur_filtre = view.findViewById(R.id.valeur_filtre);
            vh.supprimer = view.findViewById(R.id.supprimer);

            view.setTag(tag_filtre, vh);
        } else {
            vh = (AdaptaterFiltre.ViewHolder) view.getTag(tag_filtre);
        }


        vh.nom_filtre.setText(filtre.nom());



        vh.supprimer.setOnClickListener(new ControleurClicSupprimer(filtre, this, adaptateurSpinner));

        return view;
    }

    private static class ViewHolder {
        TextView nom_filtre;
        EditText valeur_filtre;
        ImageButton supprimer;


    }
}
