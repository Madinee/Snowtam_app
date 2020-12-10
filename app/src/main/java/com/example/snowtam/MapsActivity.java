package com.example.snowtam;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> 62dc7f3c51f7e934001111cece1e145960e2826c
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.snowtam.adapter.SnowtamListAdapter;
import com.example.snowtam.service.SnowtamGetter;
import com.example.snowtam.service.data.Location;
import com.example.snowtam.service.data.Snowtam;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
<<<<<<< HEAD

import java.util.ArrayList;
=======
>>>>>>> 62dc7f3c51f7e934001111cece1e145960e2826c

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Toolbar toolbar;
    FloatingActionButton fab;
<<<<<<< HEAD
    ArrayList<Snowtam> listresearch = new ArrayList<Snowtam>();
    ArrayList longTab = new ArrayList();
    ArrayList latTab = new ArrayList();

=======
>>>>>>> 62dc7f3c51f7e934001111cece1e145960e2826c
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //find view
        toolbar = findViewById(R.id.toolbar);


<<<<<<< HEAD
        //GET THE DATA TO DISPLAY ON THE MAP
        Intent resultsearchIntent = getIntent();
        Bundle bundlegot = resultsearchIntent.getBundleExtra("BUNDLE");
        listresearch = (ArrayList<Snowtam>) bundlegot.getSerializable("tabresarchs");

        Response.Listener<Location> rep = new Response.Listener<Location>() {
            @Override
            public void onResponse(Location response) {
                longTab.add(response.getLng());
                latTab.add(response.getLat());
            }
        };

        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MapsActivity", "Adresse introuvable");
            }
        };

        for(Snowtam sn: listresearch){
            SnowtamGetter.getCoordinates(MapsActivity.this, sn.getLocation(),rep,error);
        }
=======
>>>>>>> 62dc7f3c51f7e934001111cece1e145960e2826c

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
//fab button






}