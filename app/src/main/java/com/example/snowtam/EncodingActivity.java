package com.example.snowtam;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.snowtam.adapter.EncodingViewPagerAdapter;
import com.example.snowtam.adapter.SnowtamListAdapter;
import com.example.snowtam.service.data.Snowtam;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EncodingActivity extends AppCompatActivity {


    Toolbar toolbar;
    ViewPager viewPager;
    FloatingActionButton fab;
    ArrayList<Snowtam> listresearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoding);

        //find view
        fab = findViewById(R.id.floatingActionButton);
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.page_view);
        viewPager.setAdapter(new EncodingViewPagerAdapter(getSupportFragmentManager()));

        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtamEncoding);


        //Get the API data to populate the recyclerView


        //put the menu

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOptionsMenu();
            }
        });


        //Get the OACI data array
        Intent resultsearchIntent = getIntent();
        Bundle bundlegot = resultsearchIntent.getBundleExtra("BUNDLE");
        listresearch = (ArrayList<Snowtam>) bundlegot.getSerializable("taboaci");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.encoding:
                return true;
            case R.id.decoding:
                intent =new Intent(this, DecodingActivity.class);
                this.startActivity ( intent );
                return true;
            case R.id.map:
                intent =new Intent(this, MapsActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("tabResarch",listresearch);
                intent.putExtra("BUNDLE", args);
                this.startActivity ( intent );
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}