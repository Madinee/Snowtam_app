package com.example.snowtam.frament;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snowtam.R;
import com.example.snowtam.service.data.Snowtam;

public class FirstSnowtamDecodingFragment extends Fragment {

    String location,all,StateName;
    TextView airportName, allView;
    public FirstSnowtamDecodingFragment() {
        // Required empty public constructor
    }

    public static FirstSnowtamDecodingFragment newInstance(String param1, String param2) {
        FirstSnowtamDecodingFragment fragment = new FirstSnowtamDecodingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        location = getActivity().getIntent().getExtras().getString("location");
        all = getActivity().getIntent().getExtras().getString("all");
        StateName = getActivity().getIntent().getExtras().getString("StateName");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_snowtam_decoding, container, false);
        airportName = view.findViewById(R.id.airportName);
        allView = view.findViewById(R.id.all);
        Snowtam sn = new Snowtam();
        sn.setStateName(StateName);
        sn.setLocation(location);
        sn.setAll(all);
        sn.translateSnowtam();
        return view;
    }
}