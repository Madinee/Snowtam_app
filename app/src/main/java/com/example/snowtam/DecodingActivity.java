package com.example.snowtam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.snowtam.service.data.Snowtam;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DecodingActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    FloatingActionButton fab;
    Intent intent2;
    TextView airportName, allView;
    String location2,all,StateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoding);

        //find view
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.floatingActionButton);
        airportName = findViewById(R.id.airportName1);
        allView = findViewById(R.id.all1);

        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtamDecoding);

        //Get intents Data
        all = getIntent().getStringExtra("all");
        StateName = getIntent().getStringExtra("State");
        //location2 = getIntent().getStringExtra("location");
        //Show on the activity
        airportName.setText(StateName);
        Snowtam sn = new Snowtam();
        sn.setStateName(StateName);
        //sn.setLocation(location2);
        sn.setAll(all);
        allView.setText(sn.translateSnowtam(sn.getAll()));

//fab button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOptionsMenu();
            }
        });
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
                intent =new Intent(this, EncodingActivity.class);
                this.startActivity ( intent );
                return true;
            case R.id.decoding:
                return true;
            case R.id.map:
                intent =new Intent(this, MapsActivity.class);
                this.startActivity ( intent );
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}