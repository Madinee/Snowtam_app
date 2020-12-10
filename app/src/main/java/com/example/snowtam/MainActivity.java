package com.example.snowtam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.snowtam.service.SnowtamGetter;
import com.example.snowtam.service.data.Snowtam;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    SearchView searchView1, searchView2, searchView3, searchView4;
    FloatingActionButton fab;
    Button resultButton;
    Toast toastAjout;
    Toast toastNotFound;
    Toast toastError;

    public final String tabResarch ="tabresarchs";
    String searchString;
    ArrayList<Snowtam> listSearchString = new ArrayList<Snowtam>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TOAST
        Context context = getApplicationContext();
        CharSequence text = "Code OACI ajouté";
        CharSequence textFound = "Code OACI introuvable";
        CharSequence textError = "Erreur de format";

        int duration = Toast.LENGTH_SHORT;

        toastAjout = Toast.makeText(context, text, duration);
        toastNotFound = Toast.makeText(context, textFound, duration);
        toastError = Toast.makeText(context, textError, duration);

        //find views
        toolbar = findViewById(R.id.toolbar);
        searchView1 = findViewById(R.id.search1);
        fab = findViewById(R.id.floatingActionButton);
        resultButton = findViewById(R.id.showResults);


        //to change toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.snowtam);


        //to change searchview icon
        int searchIconId = searchView1.getContext().getResources().getIdentifier("android:id/search_button", null, null);
        ImageView searchIcon = searchView1.findViewById(searchIconId);
        searchIcon.setImageResource(R.drawable.ic_baseline_search_24);



        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String oaci) {
                //SET THE RESULT Visible when at least one query is made

                //On met les SNOWTAM en dur
                resultButton.setVisibility(View.VISIBLE);
                switch(oaci){
                    case "UUEE":
                        Snowtam sn = new Snowtam();
                        sn.setLocation("UUEE");
                        sn.setStateName("Russian Federation");
                        sn.setAll("(SNOWTAM 2222 A)UUEE B)12081810 C)06L F)2/2/2 H)5/5/5 N)2 C)06R F)2/2/2 H)5/5/5 N)2 R)1 S)12090010)");
                        listSearchString.add(sn);
                        toastAjout.show();
                        break;
                    case "LFPG":
                        Snowtam sn2 = new Snowtam();
                        sn2.setLocation("ENBR");
                        sn2.setStateName("Sweden");
                        sn2.setAll("(SNOWTAM 0174 A) ENBR B) 12090521 C) 17 F) 1/1/1 G) XX/XX/XX H) 5/5/5 N) ALL REPORTED TWYS/1 R) ALL REPORTED APRONS/1 T) CONTAMINATION/100/100/100/PERCENT CHEMICALS APPLIED.)");
                        listSearchString.add(sn2);
                        toastAjout.show();
                        break;
                    case "ENBO":
                        Snowtam sn3 = new Snowtam();
                        sn3.setLocation("ENBO");
                        sn3.setStateName("Sweden");
                        sn3.setAll("(SNOWTAM 0603 A) ENBO B) 12081910 C) 07 F) NIL/NIL/NIL H) 5/5/5 N) FOXTROT GOLF INDIA/1  ALPHA BRAVO CHARLIE DELTA ECHO HOTEL JULIET MIKE QRA WHISKEY YANKEE/NIL R) APRON EAST APRON WEST RWY EXTENSION WEST/NIL)");
                        listSearchString.add(sn3);
                        toastAjout.show();
                        break;
                    case "BIAR":
                        Snowtam sn4 = new Snowtam();
                        sn4.setLocation("BIAR");
                        sn4.setStateName("Iceland");
                        sn4.setAll("(SNOWTAM 2282 A) BIAR B) 12082200 C) 01 F) 3 7/3 7/3 7 G) XX/XX/XX H) 5/5/5 S) 12090600 T) RWY 01 CONTAMINATION 100 PERCENT SANDED  )");
                        listSearchString.add(sn4);
                        toastAjout.show();
                        break;
                    default:
                        toastNotFound.show();
                }
                searchView1.setQuery("", false);
                //Log tab
                for(Snowtam snowtam: listSearchString){
                    Log.i("MainActivity",snowtam.getLocation());
                }
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
                Intent intent = new Intent(MainActivity.this, SnowtamListActivity.class);
                Bundle args = new Bundle();
                args.putSerializable(tabResarch,listSearchString);
                intent.putExtra("BUNDLE", args);
                startActivity(intent);
            }
        });

    }
}
