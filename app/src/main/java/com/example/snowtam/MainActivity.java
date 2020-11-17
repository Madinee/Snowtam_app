package com.example.snowtam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    SearchView searchView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view
       toolbar = findViewById(R.id.toolbar);
        searchView=findViewById(R.id.search);
        fab = findViewById(R.id.floatingActionButton);


        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtam);



         //to change searchview icon
        int searchIconId = searchView.getContext().getResources().getIdentifier("android:id/search_button",null, null);
        ImageView searchIcon = searchView.findViewById(searchIconId);
        searchIcon.setImageResource(R.drawable.ic_baseline_search_24);

        //to change search view close icon button
//        ImageView iconClose = searchView.findViewById(R.id.search_close_btn);
//        iconClose.setColorFilter(R.color.colorPrimary);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


        //floatinf button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clic here to add more oacei code", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


}
