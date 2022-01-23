package com.example.cocktailproject.controleurs;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.cocktailproject.model.FiltreModifiable;
import com.example.cocktailproject.R;


public class ControleurValeurFiltre implements TextWatcher {
    protected final FiltreModifiable<?> filtre;
    protected final TextView vue;

    public ControleurValeurFiltre(FiltreModifiable<?> filtre, TextView vue) {
        this.filtre = filtre;
        this.vue = vue;

        this.vue.setInputType(filtre.type());
        this.vue.setText(filtre.texte());

        validerTexte(filtre.estValide());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String texteSaisi = vue.getText().toString();
        boolean validite = filtre.changerValeur(texteSaisi);

        validerTexte(validite);
    }

    protected void validerTexte(boolean valide) {
        Context contexte = vue.getContext();

        if (!valide && vue.getError() == null)
            vue.setError(contexte.getString(R.string.invalid));
        else if (valide && vue.getError() != null)
            vue.setError(null);
    }
}