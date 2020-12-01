package com.example.snowtam.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.snowtam.service.data.Snowtam;

import java.net.URLEncoder;

public class SnowtamGetter {
 private static final String  APIKEY="909c5450-286e-11eb-9a62-f1c05c5a3d15";
    public SnowtamGetter() {
    }

    public static void searchSnowtam(Context context,
                                     String oaci,
                                     Response.Listener<Snowtam> response,
                                     Response.ErrorListener errorListener
    ){
        RequestQueue queue = Volley.newRequestQueue(context);
        System.out.println("id : " +oaci);
        String url ="https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=" +APIKEY+ "-f1c05c5a3d15&format=json&criticality=1&locations="+ URLEncoder.encode(oaci);
        GsonRequest<Snowtam> gsonRequest=new GsonRequest(url, Snowtam.class,null,response,errorListener);
        queue.add(gsonRequest);
    }
}
