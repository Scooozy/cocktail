package com.example.starwarsproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.starwarsproject.adapter.PeopleAdapter;
import com.example.starwarsproject.model.People;
import com.example.starwarsproject.web.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private List<People> peopleList = new ArrayList<>();
    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.main);
        gridView = findViewById(R.id.idGridView);

        Boolean forceSide = getIntent().getExtras().getBoolean("forceSide");
        if (forceSide){
            view.setBackgroundColor(Color.rgb( 80, 10, 2));
        }else{

            view.setBackgroundColor(Color.rgb( 2, 10, 80));
        }

        getAllImage();


    }
    public void getAllImage(){
        Call<List<People>> peopleImage = ApiClient.getInterface().getAllImages();
        peopleImage.enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {

                if (response.isSuccessful()){
                    String message = "Request succesful ...";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();

                    peopleList = response.body();
                    PeopleAdapter peopleAdapter = new PeopleAdapter(peopleList, MainActivity.this);
                    gridView.setAdapter(peopleAdapter);
                }else{
                    String message = "An error occured try again later ...";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }


}