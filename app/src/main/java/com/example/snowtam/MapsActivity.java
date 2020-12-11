package com.example.snowtam;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Toolbar toolbar;
    FloatingActionButton fab;
    ArrayList<Double> longTab = new ArrayList<Double>();
    ArrayList<Double> latTab = new ArrayList<Double>();
    String location;
    Address address;

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


        //GET THE DATA TO DISPLAY ON THE MAP
       Intent intent = getIntent();
       location = intent.getExtras().getString("location");
       intent.putExtra("location", location);
       Log.i("MapsActivity", location);

        //Geocoder test
        Geocoder geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
        try {
            List<Address> listAdress = geocoder.getFromLocationName(location, 1);
            if(listAdress.size()>0){
                address = listAdress.get(0);
                latTab.add(address.getLatitude());
                longTab.add(address.getLongitude());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        /*
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
            SnowtamGetter.getCoordinates(MapsActivity.this, location,rep,error);

         */

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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera

        for(Double lat : latTab ){
            LatLng airport1 = new LatLng(lat, longTab.get(latTab.indexOf(lat)));
            mMap.addMarker(new MarkerOptions().position(airport1).title("Marker in airport "+longTab.get(latTab.indexOf(lat))+1));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(airport1));
        }
    }
//fab button






}