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
import com.example.cocktailproject.model.People;

import java.util.List;

public class LegendsPeopleAdapter extends BaseAdapter{

    private List<People> peopleImage;
    private Context context;


    public LegendsPeopleAdapter(List<People> peopleImage, Context context) {
        this.peopleImage = peopleImage;
        this.context = context;
    }

    @Override
    public int getCount() {
        return peopleImage.size();
    }

    @Override
    public Object getItem(int i) {
        return peopleImage.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_cocktail_detail,viewGroup, false);
        }
        ImageView imageView =view.findViewById(R.id.imgViewy);
        TextView textView = view.findViewById(R.id.textViewGrid2);

        textView.setText(peopleImage.get(i).getName());
        GlideApp.with(context).load(peopleImage.get(i).getImage()).into(imageView);
        System.out.println(peopleImage.get(i).getImage());


        return view;
    }
}
