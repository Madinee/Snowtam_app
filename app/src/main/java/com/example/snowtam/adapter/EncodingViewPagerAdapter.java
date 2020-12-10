package com.example.snowtam.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.snowtam.frament.FirstSnowtamEncodingFragment;
import com.example.snowtam.frament.FourthSnowtamEncodingFragment;
import com.example.snowtam.frament.SecondSnowtamEncodinfFragment;
import com.example.snowtam.frament.ThirdSnowtamEncodingFragment;

public class EncodingViewPagerAdapter extends FragmentPagerAdapter {

    public EncodingViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FirstSnowtamEncodingFragment(); //ChildFragment1 at position 0
            case 1:
                return new SecondSnowtamEncodinfFragment(); //ChildFragment2 at position 1
            case 2:
                return new ThirdSnowtamEncodingFragment(); //ChildFragment3 at position 2
            case 3:
                return new FourthSnowtamEncodingFragment(); //ChildFragment3 at position 3
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 4;
    }
}