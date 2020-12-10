package com.example.snowtam.frament;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snowtam.R;


public class FirstSnowtamEncodingFragment extends Fragment {

    TextView airportName, all;
    // TODO: Rename parameter arguments, choose names that match


    public FirstSnowtamEncodingFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FirstSnowtamEncodingFragment newInstance(String param1, String param2) {
        FirstSnowtamEncodingFragment fragment = new FirstSnowtamEncodingFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_snowtam_encoding, container, false);
    }
}