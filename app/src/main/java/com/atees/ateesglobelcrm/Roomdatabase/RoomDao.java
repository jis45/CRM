package com.atees.ateesglobelcrm.Roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomDao {
    @Insert
    void insert(RoomData roomData);
    @Update
    void update(RoomData roomData);
    @Delete
    void delete(RoomData roomData);

    @Query("DELETE From roomsaveData")
    void deleteAlldatabase();

    @Query("SELECT * From roomsaveData")
    LiveData<List<RoomData>> getAlldatabase();
}

