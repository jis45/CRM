package com.atees.ateesglobelcrm.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atees.ateesglobelcrm.Adapter.RoomRecycleViewAdapter;
import com.atees.ateesglobelcrm.MainActivity;
import com.atees.ateesglobelcrm.R;
import com.atees.ateesglobelcrm.Roomdatabase.AddlistViewModel;
import com.atees.ateesglobelcrm.Roomdatabase.RoomData;
import com.atees.ateesglobelcrm.Roomdatabase.RoomVewmodel;

import java.util.List;

import io.github.muddz.styleabletoast.StyleableToast;

public class mainfragment1 extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private RoomVewmodel roomVewmodel;
    private RoomRecycleViewAdapter roomRecycleViewAdapter;



    public  mainfragment1(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mainfragment1, container, false);

        layoutManager =new LinearLayoutManager(getActivity());

        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        roomRecycleViewAdapter=new RoomRecycleViewAdapter();
        recyclerView.setAdapter(roomRecycleViewAdapter);
        roomRecycleViewAdapter.setContext(getContext());





        roomVewmodel = ViewModelProviders.of(this).get(RoomVewmodel.class);
        roomVewmodel.getAlldatabase().observe(getActivity(), new Observer<List<RoomData>>() {
            @Override
            public void onChanged(List<RoomData> roomData) {
//                                StyleableToast.makeText(getActivity(), "datasaved", R.style.Toast).show();
                    roomRecycleViewAdapter.setDataBase(roomData);
            }
        });





        return view;
    }
}