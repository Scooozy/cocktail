package com.example.cocktailproject.controleurs;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Controleur {
    protected static void cacherClavier(View vue) {
        Context contexte = vue.getContext();
        InputMethodManager manager = (InputMethodManager) contexte.getSystemService(Activity.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(vue.getWindowToken(), 0);
    }
}
