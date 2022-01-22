package com.example.cocktailproject.vue;


import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.example.cocktailproject.R;
/**
 * Un texte que l’on peut mettre à jour pour informer l’utilisateur de l’état de la recherche.
 */
public class VueMessage extends androidx.appcompat.widget.AppCompatTextView {

    public VueMessage(Context context) {
        super(context);
    }

    public VueMessage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VueMessage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * L’utilisateur a mal renseigné un paramètre.
     */
    public void erreurParametre() {
        setText(getContext().getString(R.string.error));
        setVisibility(VISIBLE);
    }

    /**
     * La recherche a réussi.
     */
    public void succes() {
        setVisibility(INVISIBLE);
    }

    /**
     * La recherche est correcte mais il n’y a aucun résultat.
     */
    public void aucunResultat() {
        setText(getContext().getString(R.string.no_result));
        setVisibility(VISIBLE);
    }

    /**
     * Pas de connexion à internet.
     */
    public void erreurConnexion() {
        setText(getContext().getString(R.string.connection_failed));
        setVisibility(VISIBLE);
    }
}
