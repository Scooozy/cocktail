package com.example.cocktailproject.controleurs;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.cocktailproject.model.FiltreModifiable;
import com.example.cocktailproject.R;

/**
 * Controleur de modification de la valeur d’un filtre. En fonction du type de filtre (numérique,
 * littéral…), valide ou invalide le texte entré par l’utilisateur.
 */
public class ControleurValeurFiltre implements TextWatcher {
    protected final FiltreModifiable<?> filtre;
    protected final TextView vue;

    /**
     * Crée un controleur de valeur de filtre.
     * 
     * @param filtre le filtre dont on contrôle la valeur.
     * @param vue la TextView qui modifie la valeur du filtre.
     */
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

    /**
     * Notifie l’utilisateur si et seulement s’il y a une erreur dans le format.
     * 
     * @param valide true si le format est valide.
     */
    protected void validerTexte(boolean valide) {
        Context contexte = vue.getContext();

        if (!valide && vue.getError() == null)
            vue.setError(contexte.getString(R.string.invalid));
        else if (valide && vue.getError() != null)
            vue.setError(null);
    }
}