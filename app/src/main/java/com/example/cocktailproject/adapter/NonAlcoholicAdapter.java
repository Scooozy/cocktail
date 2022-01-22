package com.example.cocktailproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cocktailproject.R;
import com.example.cocktailproject.glide.GlideApp;
import com.example.cocktailproject.model.Cocktails;

import java.util.List;

public class NonAlcoholicAdapter extends BaseAdapter{

    private List<Cocktails> cocktailNonAlcoolicList;
    private Context context;
    TextView textView;


    public NonAlcoholicAdapter(List<Cocktails> cocktailNonAlcoolicList, Context context) {
        this.cocktailNonAlcoolicList = cocktailNonAlcoolicList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cocktailNonAlcoolicList.size();
    }

    @Override
    public Object getItem(int i) {
        return cocktailNonAlcoolicList.get(i);
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



        textView.setText(cocktailNonAlcoolicList.get(i).getStrDrink());
        GlideApp.with(context).load(cocktailNonAlcoolicList.get(i).getStrDrinkThumb()).into(imageView);


        return view;
    }
}
