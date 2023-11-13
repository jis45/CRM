package com.atees.ateesglobelcrm.Roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomVewmodel extends AndroidViewModel {

    private  RoomRepository repository;
    private LiveData<List<RoomData>>mAlldatabase;

    public RoomVewmodel(@NonNull Application application) {
        super(application);
        repository =new RoomRepository(application);
        mAlldatabase=repository.getAlldatabase();
    }
    public  void insert(RoomData roomData){
        repository.insert(roomData);
    }
    public  void delete(RoomData roomData){
        repository.delete(roomData);
    }
    public  void update(RoomData roomData){
        repository.update(roomData);
    }
    public  void deleteAllword(){
        repository.deleteAlldatabase();
    }

    public LiveData<List<RoomData >> getAlldatabase(){
        return  mAlldatabase;
    }
}
