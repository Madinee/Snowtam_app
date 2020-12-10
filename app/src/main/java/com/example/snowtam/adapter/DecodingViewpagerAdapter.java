package com.example.snowtam.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.snowtam.frament.FirstSnowtamDecodingFragment;

import com.example.snowtam.frament.FourthSnowtamDecodingFragment;

import com.example.snowtam.frament.SecondSnowtamDecodingFragment;

import com.example.snowtam.frament.ThirdSnowtamDecodingFragment;


public class DecodingViewpagerAdapter  extends FragmentPagerAdapter {

    public DecodingViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FirstSnowtamDecodingFragment(); //ChildFragment1 at position 0
            case 1:
                return new SecondSnowtamDecodingFragment(); //ChildFragment2 at position 1
            case 2:
                return new ThirdSnowtamDecodingFragment(); //ChildFragment3 at position 2
            case 3:
                return new FourthSnowtamDecodingFragment(); //ChildFragment3 at position 3
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 4;
    }
}
