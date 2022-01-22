package com.example.cocktailproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocktailproject.MainActivity;
import com.example.cocktailproject.R;
import com.example.cocktailproject.glide.GlideApp;
import com.example.cocktailproject.model.Cocktail;
import com.example.cocktailproject.model.CocktailWrapper;
import com.example.cocktailproject.model.Cocktails;
import com.example.cocktailproject.model.CocktailsWrapper;
import com.example.cocktailproject.web.ApiClient;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlcoolicAdapter extends BaseAdapter{

    private List<Cocktails> cocktailAlcoolicList;
    private List<Cocktail> cocktailAlcoolicNameList;
    private Context context;
    TextView textView;


    public AlcoolicAdapter(List<Cocktails> cocktailAlcoolicList, Context context) {
        this.cocktailAlcoolicList = cocktailAlcoolicList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cocktailAlcoolicList.size();
    }

    @Override
    public Object getItem(int i) {
        return cocktailAlcoolicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //recupere ceux entre 100BBY et 100ABY
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_cocktail_detail,viewGroup, false);
        }
        textView = view.findViewById(R.id.textViewGrid2);

        ImageView imageView =view.findViewById(R.id.imgViewy);

        Call<CocktailWrapper> coctailAlcoolicName = ApiClient.getInterface().getDrinkById(cocktailAlcoolicList.get(i).getIdDrink());
        coctailAlcoolicName.enqueue(new Callback<CocktailWrapper>() {
            @Override
            public void onResponse(Call<CocktailWrapper> call, Response<CocktailWrapper> response) {
                if (response.isSuccessful()){

                    cocktailAlcoolicNameList = response.body().getDrinkName();
                    System.out.println(cocktailAlcoolicNameList);
                    textView.setText(cocktailAlcoolicNameList.get(0).getStrDrink());




                }
            }

            @Override
            public void onFailure(Call<CocktailWrapper> call, Throwable t) {

            }
        });


        //textView.setText(cocktailAlcoolicNameList.get(i).getStrDrink());
        GlideApp.with(context).load(cocktailAlcoolicList.get(i).getStrDrinkThumb()).into(imageView);


        return view;
    }
}
