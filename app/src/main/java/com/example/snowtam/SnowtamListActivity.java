package com.example.snowtam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SnowtamListActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button recentButton;
    Button favoritesButton;
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
            @Override
            public void onClick(View view) {
                recentButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        favoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoritesButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });


    }
}