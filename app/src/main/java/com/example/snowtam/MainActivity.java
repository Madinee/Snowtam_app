package com.example.snowtam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText search1, search2, search3, search4;
    FloatingActionButton fab;
    Button resultButton;
    int addAnotherSeachBox=1;

    public final String tabResarch ="tabresarchs";
    String searchString;
    ArrayList<String> listSearchString = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find views
        toolbar = findViewById(R.id.toolbar);
        search1 = findViewById(R.id.search1);
        search2 = findViewById(R.id.search2);
        search3 = findViewById(R.id.search3);
        search4 = findViewById(R.id.search4);
        fab = findViewById(R.id.floatingActionButton);
        resultButton = findViewById(R.id.showResults);


        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtam);




        //floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAnotherSeachBox++;
                switch(addAnotherSeachBox) {
                    case 2:
                        search2.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        search3.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        search4.setVisibility(View.VISIBLE);
                        break;
                    default:
                        Snackbar.make(view, "Sorry you can't enter no more than 4 icao code at the same time", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                }

            }

        });

        resultButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(search1.getText().toString().trim()) &&TextUtils.isEmpty(search2.getText().toString().trim())&&TextUtils.isEmpty(search3.getText().toString().trim())&&TextUtils.isEmpty(search4.getText().toString().trim())){
                    Toast.makeText(MainActivity.this, "Enter at least one icao code",Toast.LENGTH_LONG).show();
                }
                else {

                    Intent intent = new Intent(MainActivity.this, SnowtamListActivity.class);
        //                intent.putStringArrayListExtra(tabResarch, listSearchString);
                    intent.putExtra("oaci1", search1.getText().toString().trim());
                    intent.putExtra("oaci2", search2.getText().toString().trim());
                    intent.putExtra("oaci3", search3.getText().toString().trim());
                    intent.putExtra("oaci4", search4.getText().toString().trim());

                    startActivity(intent);
                }
            }
        });

    }
}
