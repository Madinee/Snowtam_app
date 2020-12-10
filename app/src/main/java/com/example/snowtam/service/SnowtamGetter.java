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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.snowtam.MainActivity;
import com.example.snowtam.service.data.Snowtam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SnowtamGetter {
 private static final String  APIKEY="c63cfde0-3a51-11eb-aa88-ab02fc941694";
    public SnowtamGetter() {
    }

    public static Snowtam searchSnowtam(Context context,
                                     String oaci


    ){
        RequestQueue queue = Volley.newRequestQueue(context);
       final Snowtam  snowtam=new Snowtam();
        System.out.println("id : " +oaci);
       final String url ="https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=" +APIKEY+ "&format=json&criticality=1&locations="+ oaci;
        //System.out.println( url);
       // final String url="http://10.188.192.167:"+oaci+"/icao";
        System.out.println( url);

        StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                // Parsing json
                System.out.println(snowtam.toString());
                try {


                    JSONArray array=new JSONArray(response);
                    JSONObject obj = array.getJSONObject(0);

                    snowtam.setLocation(obj.getString("location"));
                    snowtam.setStateName(obj.getString("StateName"));

                    System.out.println(snowtam.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
                Log.d("error","API error");
            }
        });
// Adding request to request queue
        queue.add(req);
        return snowtam;

    }


}
