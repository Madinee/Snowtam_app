package com.example.snowtam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.snowtam.adapter.SnowtamListAdapter;
import com.example.snowtam.service.SnowtamGetter;
import com.example.snowtam.service.data.Snowtam;

import java.util.ArrayList;

public class SnowtamListActivity extends AppCompatActivity {
    private static final String TAG = "SnowtamlistActivity";
    Toolbar toolbar;
    Button recentButton;
    Button favoritesButton;
    Intent resultsearchIntent = getIntent();
    ArrayList<String> listresearch = new ArrayList<String>();
    String[] listresearchArray;
    RecyclerView recyclerView = findViewById(R.id.recycler_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowtam_list);

        //find view
        toolbar = findViewById(R.id.toolbar);
        recentButton=findViewById(R.id.recentButton);
        favoritesButton=findViewById(R.id.favoriButton);

        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtamlist);


        //button onclick
        recentButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                recentButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                recentButton.setTextColor(getResources().getColor(R.color.colorWhite));
            }
        });

        favoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoritesButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                favoritesButton.setTextColor(getResources().getColor(R.color.colorWhite));

            }
        });

        //Get the data and display them in the recyclerView

        listresearch = resultsearchIntent.getStringArrayListExtra("tabresarchs");
        listresearchArray = (String[]) listresearch.toArray();

        Response.Listener<Snowtam> rep = new Response.Listener<Snowtam>() {
            @Override
            public void onResponse(Snowtam response) {
                SnowtamListAdapter snlAdapter = new SnowtamListAdapter(listresearchArray);
                recyclerView.setAdapter(snlAdapter);
            };
            final Response.ErrorListener error = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "Search snowTam error"+error.getMessage());
                }
            };

        };

    }
}