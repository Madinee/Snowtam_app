package com.example.snowtam.service;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.snowtam.MainActivity;
import com.example.snowtam.service.data.Location;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.snowtam.MainActivity;
import com.example.snowtam.service.data.Snowtam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SnowtamGetter {
 private static final String  APIKEY="c63cfde0-3a51-11eb-aa88-ab02fc941694";
 private static final String gmAPIKEY="AIzaSyBJAYeGGnwlJue6Amu_feJogmJvArGKHVA";

    public SnowtamGetter() {
    }

    public static void searchSnowtam(Context context,
                                     String oaci


    ){
        RequestQueue queue = Volley.newRequestQueue(context);
       final Snowtam  snowtam=new Snowtam();
        System.out.println("id : " +oaci);
//        final String url ="https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=" +APIKEY+ "&format=json&criticality=1&locations="+ oaci;
//        System.out.println( url);
        final String url="http://10.188.192.167:"+oaci+"/icao";
        System.out.println( url);
    }

    public static void getCoordinates(Context context, String address, Response.Listener<Location> response, Response.ErrorListener error) {

        String url = "https://maps.googleapis.com/maps/api/geocode/json?address="+address;
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<Location> gsonRequest = new GsonRequest<Location>(url, Location.class, null, response, error);
// Access the RequestQueue through your singleton class.
        queue.add(gsonRequest);
    }

}
