package com.example.snowtam.frament;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snowtam.R;
import com.example.snowtam.service.data.Snowtam;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstSnowtamEncodingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstSnowtamEncodingFragment extends Fragment {

    TextView airportName, allView;
    String location,all,StateName;

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
        location = getActivity().getIntent().getExtras().getString("location");
        all = getActivity().getIntent().getExtras().getString("all");
        StateName = getActivity().getIntent().getExtras().getString("StateName");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first_snowtam_encoding, container, false);

        airportName = view.findViewById(R.id.airportName);
        allView = view.findViewById(R.id.all);
        Snowtam sn = new Snowtam();
        sn.setStateName(StateName);
        sn.setLocation(location);
        sn.setAll(all);
        allView.setText(sn.getSnowtamData(sn.getAll()));
        airportName.setText(StateName);
        return view;

    }
}