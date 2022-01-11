package com.example.starwarsproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.starwarsproject.adapter.PeopleAdapter;
import com.example.starwarsproject.model.People;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PeopleAdapter.OnPeopleListener {

    private static String URL = "https://akabab.github.io/starwars-api/api/all.json";

    List<People> peopleList;
    RecyclerView recyclerView;
    SeekBar seekBar;
    TextView compteur;
    Button btnRecherche;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peopleList = new ArrayList<>();
        recyclerView = findViewById(R.id.idRecycler);
        seekBar = findViewById(R.id.seekBar);
        compteur = findViewById(R.id.compteur);
        btnRecherche = findViewById(R.id.btnFind);
        EditText txtPersonName = findViewById(R.id.txtPersonName);
        
        GetData getData = new GetData();
        getData.execute();

        txtPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /*seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                compteur.setText(String.valueOf(progress));
                peopleList.clear();
                String compt;
                compt = compteur.getText().toString();
                if (compt.matches("0")) {
                    AlertDialog.Builder error = new AlertDialog.Builder(MainActivity.this);
                    error.setMessage("Ask to view more people !!")
                            .setTitle("Error");
                    error.create();
                    error.show();
                } else {
                    URL = URL + ;
                    GetData getData = new GetData();
                    getData.execute();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/




        btnRecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peopleList.clear();
                Log.d("mss", "++++++++++"+txtPersonName.getText());
                String name;
                name = txtPersonName.getText().toString();
                if (name.matches("")){
                    AlertDialog.Builder error = new AlertDialog.Builder(MainActivity.this);
                    error.setMessage("You must enter the name of a people !!")
                            .setTitle("Error");
                    error.create();
                    error.show();
                }else {
                    URL = URL + "?beer_name=" + txtPersonName.getText();
                    GetData getData = new GetData();
                    getData.execute();
                }

            }
        });
    }

    @Override
    public void onPeopleClick(int position) {
        //intent vers affichage
    }

    public class GetData extends AsyncTask<String, String, String> {

                @Override
                protected String doInBackground(String... strings) {

                    String current = "";
                    try {
                        java.net.URL url;
                        HttpURLConnection urlConnection = null;
                        try {
                            url = new URL(URL);
                            Log.d("url", "++++++++++++"+url);
                            urlConnection = (HttpURLConnection) url.openConnection();

                            InputStream is = urlConnection.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);

                            int data = isr.read();
                            while (data != -1){
                                current +=(char) data;
                                data = isr.read();
                            }
                            return current;

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            if (urlConnection != null){
                                urlConnection.disconnect();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return current;
                }

                @Override
                protected void onPostExecute(String s) {


                    try {

                        //JSONObject jsonObject = new JSONObject(s);
                        JSONArray jsonArray = new JSONArray(s);
                        Log.d("array", "++++++++++++++"+jsonArray.length());
                        if (jsonArray.length() == 0){
                            AlertDialog.Builder error = new AlertDialog.Builder(MainActivity.this);
                            error.setMessage("the people doesn't exist !!")
                                    .setTitle("Error");
                            error.create();
                            error.show();
                        }else {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                People model = new People();
                                model.setName(jsonObject1.getString("name"));
                                model.setImage(jsonObject1.getString("image"));
                                peopleList.add(model);
                            }
                        }

                        URL = "https://akabab.github.io/starwars-api/api/all.json";

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    PutDataIntoRecyclerView(peopleList);
                }
            }
            private  void PutDataIntoRecyclerView(List<People> peopleList){
                System.out.println(peopleList);
                PeopleAdapter adapter = new PeopleAdapter(this, peopleList, this);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);


            }
        }