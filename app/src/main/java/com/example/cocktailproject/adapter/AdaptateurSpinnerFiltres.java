package com.example.cocktailproject.adapter;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.example.cocktailproject.R;
import com.example.cocktailproject.model.Filtre;

import java.util.ArrayList;
import java.util.Map;

public class AdaptateurSpinnerFiltres extends ArrayAdapter<String> {
    protected final Spinner spinner;

    public AdaptateurSpinnerFiltres(@NonNull Spinner spinner, @NonNull Map<String, Integer> filtres) {
        super(spinner.getContext(), R.layout.support_simple_spinner_dropdown_item, new ArrayList<>());

        this.spinner = spinner;

        add(spinner.getContext().getString(R.string.select));
        for (String nom_filtre : filtres.keySet())
            add(nom_filtre);
    }

    public AdaptateurSpinnerFiltres(Spinner spinner) {
        this(spinner, Filtre.par_defaut());
    }

    @Override
    public void add(String nouveau) {
        int nbElements = getCount();

        if (nbElements > 0)
            spinner.setVisibility(View.VISIBLE);

        // Le premier élément doit toujours être le "Select filter".
        if (nbElements > 1) {
            for (int i = 1; i < getCount(); i++) {
                if (getItem(i).compareTo(nouveau) > 0) {
                    insert(nouveau, i);
                    return;
                }
            }
            super.add(nouveau);
        } else {
            super.add(nouveau);
        }
    }

    @Override
    public void remove(String nom_filtre) {
        super.remove(nom_filtre);

        if (getCount() < 2)
            spinner.setVisibility(View.GONE);
    }
}
