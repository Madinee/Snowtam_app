package com.example.snowtam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.snowtam.adapter.SnowtamListAdapter;
import com.example.snowtam.service.SnowtamGetter;
import com.example.snowtam.service.data.Snowtam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SnowtamListActivity extends AppCompatActivity {
    private static final String TAG = "SnowtamlistActivity";
    private static final String  APIKEY="909c5450-286e-11eb-9a62";
    Toolbar toolbar;
    Button recentButton;
    Button favoritesButton;
    List<Snowtam> listresearch= new ArrayList();
    RecyclerView recyclerView;
    SnowtamListAdapter mAdapter;
//    TextView oaciCode, airportName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowtam_list);

        //find view
        toolbar = findViewById(R.id.toolbar);
        recentButton=findViewById(R.id.recentButton);
        favoritesButton=findViewById(R.id.favoriButton);
//        oaciCode=findViewById(R.id.oaciCode);
//        airportName=findViewById(R.id.airportName);
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

//        Intent resultsearchIntent = getIntent();
//        listresearch = resultsearchIntent.getStringArrayListExtra("tabresarchs");
//        snowtamListAdapter=new SnowtamListAdapter(listresearch);
//        recyclerView.setAdapter(snowtamListAdapter);

        //get icoa
        String oaci1 = getIntent().getStringExtra("oaci1");
        String oaci2 = getIntent().getStringExtra("oaci2");
        String oaci3 = getIntent().getStringExtra("oaci3");
        String oaci4 = getIntent().getStringExtra("oaci4");

        List<String> oacicodeList = new ArrayList<>();
        if(!TextUtils.isEmpty(oaci1)){
//            oacicodeList.add(oaci1);
            oacicodeList.add("8080");
        }
        if(!TextUtils.isEmpty(oaci2)){
            oacicodeList.add(oaci2);


        }
        if(!TextUtils.isEmpty(oaci3)){
            oacicodeList.add(oaci3);

        }
        if(!TextUtils.isEmpty(oaci4)){
            oacicodeList.add(oaci4);


        }



        for (int i = 0; i < oacicodeList.size(); i++) {
          listresearch.add(SnowtamGetter.searchSnowtam(SnowtamListActivity.this, oacicodeList.get(i)));
            mAdapter=new SnowtamListAdapter(listresearch);
            recyclerView.setAdapter(mAdapter);

        }







//        Response.Listener<Snowtam> rep = new Response.Listener<Snowtam>() {
//            @Override
//            public void onResponse(Snowtam response) {
//                mAdapter = new SnowtamListAdapter(listresearch);
//                recyclerView.setAdapter(mAdapter);
//            }
//        };
//        final Response.ErrorListener error = new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "searchSnowtam onErrorResponse: " + error.getMessage());
//            }
//        };
//
//        SnowtamGetter.searchSnowtam(SnowtamListActivity.this, oaci, rep, error);
    }


}
