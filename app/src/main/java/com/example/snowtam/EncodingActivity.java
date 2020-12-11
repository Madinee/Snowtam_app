package com.example.snowtam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.snowtam.service.data.Snowtam;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EncodingActivity extends AppCompatActivity {


    Toolbar toolbar;
    ViewPager viewPager;
    FloatingActionButton fab;
    String location;
    Intent intent2;
    TextView airportName, allView;
    String location2,all,StateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoding);

        //find view
        fab = findViewById(R.id.floatingActionButton);
        toolbar = findViewById(R.id.toolbar);

        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtamEncoding);

        //Get intents datas
        location2 = getIntent().getExtras().getString("location");
        all = getIntent().getExtras().getString("all");
        StateName = getIntent().getExtras().getString("StateName");

        //TEST
        airportName = findViewById(R.id.airportName);
        allView = findViewById(R.id.all);
        Snowtam sn = new Snowtam();
        sn.setStateName(StateName);
        sn.setLocation(location);
        sn.setAll(all);
        allView.setText(sn.getSnowtamData(sn.getAll()));
        airportName.setText(StateName);

        //Get the API data to populate the recyclerView
        Intent intent = getIntent();
        location = intent.getExtras().getString("location");
        Log.i("EncodingActvity", location);
        //put the menu

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
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.encoding:
                return true;
            case R.id.decoding:
                intent2 =new Intent(this, DecodingActivity.class);
                intent2.putExtra("all", all);
                //intent2.putExtra("location", location);
                intent2.putExtra("State", StateName);
                this.startActivity ( intent2 );
                return true;
            case R.id.map:
                /*
                intent2.putExtra("location", location);
                intent2 =new Intent(this, MapsActivity.class);
                this.startActivity ( intent2 );

                 */
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}