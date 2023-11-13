package com.atees.ateesglobelcrm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class SlidePagerAdapter  extends FragmentStateAdapter {
    private final List<Fragment> fragments;


    public SlidePagerAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }


    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public void setDropDownViewResource(int simpleSpinnerDropdownItem) {

    }
}
