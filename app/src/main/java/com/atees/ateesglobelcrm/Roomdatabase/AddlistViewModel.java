package com.atees.ateesglobelcrm.Roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddlistViewModel extends AndroidViewModel {

    private  RoomRepository repository;

    public AddlistViewModel(@NonNull Application application) {
        super(application);
        repository =new RoomRepository(application);

    }
    public  void insert(RoomData roomData){
        repository.insert(roomData);
    }

    public  void update(RoomData roomData){
        repository.update(roomData);
    }



}
