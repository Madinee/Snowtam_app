package com.example.snowtam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Response;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    SearchView searchView;
    FloatingActionButton fab;
    Button resultButton;

    public final String tabResarch ="tabresarchs";
    String searchString;
    ArrayList<String> listSearchString = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find views
        toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.search);
        fab = findViewById(R.id.floatingActionButton);
        resultButton = findViewById(R.id.showResults);


        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtam);


        //to change searchview icon
        int searchIconId = searchView.getContext().getResources().getIdentifier("android:id/search_button", null, null);
        ImageView searchIcon = searchView.findViewById(searchIconId);
        searchIcon.setImageResource(R.drawable.ic_baseline_search_24);

        //to change search view close icon button
//        ImageView iconClose = searchView.findViewById(R.id.search_close_btn);
//        iconClose.setColorFilter(R.color.colorPrimary);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String oaci) {
                //SET THE RESULT Visible when at least one query is mad
                /*resultButton.setVisibility(View.VISIBLE);
                listSearchString.add(oaci);

                 */
                Intent intent = new Intent(MainActivity.this, SnowtamListActivity.class);
                // intent.putStringArrayListExtra(tabResarch, listSearchString);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


        //floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click here to add more oacei code", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

        });

        //Show the list of airports
        resultButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

    }
}
