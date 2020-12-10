package com.example.snowtam;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
    private static final String  APIKEY="c63cfde0-3a51-11eb-aa88-ab02fc941694";
    private ProgressDialog pDialog;

    private Toolbar toolbar;
    private Button recentButton;
    private Button favoritesButton;
    private List<Snowtam> listresearch;
    private RecyclerView recyclerView;
    private SnowtamListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowtam_list);

        listresearch=new ArrayList<>();
        //find view
        toolbar = findViewById(R.id.toolbar);
        recentButton=findViewById(R.id.recentButton);
        favoritesButton=findViewById(R.id.favoriButton);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
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
               Intent intent =new Intent(SnowtamListActivity.this, EncodingActivity.class);
                SnowtamListActivity.this.startActivity ( intent );
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
            oacicodeList.add(oaci1);
            // oacicodeList.add("8080");
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
        System.out.println( oacicodeList.size());
//get the list of snowtam

        for (int i = 0; i < oacicodeList.size(); i++) {

            RequestQueue queue = Volley.newRequestQueue(this);
            final Snowtam  snowtam=new Snowtam();

            final String url ="https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=" +APIKEY+ "&format=json&criticality=1&locations="+ oacicodeList.get(i);
            System.out.println( url);
            StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    hidePDialog();
                    // Parsing json
                    try {
                        JSONArray array=new JSONArray(response);
                        if (array.length() > 0) {
                            JSONObject obj = array.getJSONObject(0);
                            snowtam.setLocation(obj.getString("location"));
                            snowtam.setStateName(obj.getString("StateName"));
                            listresearch.add(snowtam);
                            mAdapter = new SnowtamListAdapter(listresearch);
                            recyclerView.setAdapter(mAdapter);
                            System.out.println(snowtam.toString());
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("error",error.toString());
                    hidePDialog();

                    Toast.makeText(getApplicationContext(), "Api error try later", Toast.LENGTH_SHORT).show();
                }
            });
// Adding request to request queue
            queue.add(req);



        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
}
}