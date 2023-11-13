package com.atees.ateesglobelcrm.Adapter;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.atees.ateesglobelcrm.Fragment.extrInfoFragment;
import com.atees.ateesglobelcrm.Fragment.internalNotesFragment;

public class EditinteralnotAdapter extends FragmentStateAdapter {


    public EditinteralnotAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

       if (position ==1){
           return  new extrInfoFragment();
       }
        return new internalNotesFragment();
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
