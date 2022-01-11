package com.example.starwarsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.starwarsproject.R;
import com.example.starwarsproject.model.People;


import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder> {

    private Context mContext;
    private List<People> mData;
    private OnPeopleListener mOnPeopleListener;

    public PeopleAdapter(Context mContext, List<People> mData, OnPeopleListener mOnPeopleListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.mOnPeopleListener = mOnPeopleListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.activity_people_item, parent, false);

        return new MyViewHolder(v, mOnPeopleListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getName());
        Glide.with(mContext)
                .load(mData.get(position).getImage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        ImageView img;
        OnPeopleListener onPeopleListener;

        public MyViewHolder(@NonNull View itemView, OnPeopleListener onPeopleListener) {
            super(itemView);

            name = itemView.findViewById(R.id.txtName);
            img = itemView.findViewById(R.id.imgPeople);
            this.onPeopleListener = onPeopleListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onPeopleListener.onPeopleClick(getAdapterPosition());
        }
    }

    public interface OnPeopleListener{
        void onPeopleClick(int position);
    }
}
