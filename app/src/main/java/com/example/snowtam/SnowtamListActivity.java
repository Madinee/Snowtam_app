package com.example.snowtam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.snowtam.adapter.SnowtamListAdapter;
import com.example.snowtam.service.SnowtamGetter;
import com.example.snowtam.service.data.Snowtam;

import java.util.ArrayList;
import java.util.List;

public class SnowtamListActivity extends AppCompatActivity {
    private static final String TAG = "SnowtamlistActivity";
    Toolbar toolbar;
    Button recentButton;
    Button favoritesButton;
    ArrayList<Snowtam> listresearch;
    RecyclerView recyclerView;
    SnowtamListAdapter snowtamListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowtam_list);

        //find view
        toolbar = findViewById(R.id.toolbar);
        recentButton=findViewById(R.id.recentButton);
        favoritesButton=findViewById(R.id.favoriButton);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

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
//
        Intent resultsearchIntent = getIntent();
        Bundle bundlegot = resultsearchIntent.getBundleExtra("BUNDLE");
        listresearch = (ArrayList<Snowtam>)bundlegot.getSerializable("tabresarchs");
        snowtamListAdapter=new SnowtamListAdapter(listresearch);
        recyclerView.setAdapter(snowtamListAdapter);

       /* for(int i=0; i<listresearchArray.length;i++){
            SnowtamGetter.searchSnowtam(this, listresearchArray[i], rep, error);
        }

       */


    }
}