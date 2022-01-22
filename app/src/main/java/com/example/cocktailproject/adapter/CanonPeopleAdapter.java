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

public class CanonPeopleAdapter extends BaseAdapter{

    private List<People> peopleCanon;
    private Context context;


    public CanonPeopleAdapter(List<People> peopleCanon, Context context) {
        this.peopleCanon = peopleCanon;
        this.context = context;
    }

    @Override
    public int getCount() {
        return peopleCanon.size();
    }

    @Override
    public Object getItem(int i) {
        return peopleCanon.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //recupere ceux entre 100BBY et 100ABY
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_people_item,viewGroup, false);
        }
        String birth = peopleCanon.get(i).getBirth_year();


        ImageView imageView =view.findViewById(R.id.imgViewy);
        TextView textView = view.findViewById(R.id.textViewGrid2);

        textView.setText(peopleCanon.get(i).getName());
        GlideApp.with(context).load(peopleCanon.get(i).getImage()).into(imageView);
        System.out.println(peopleCanon.get(i).getImage());


        return view;
    }
}
