package com.atees.ateesglobelcrm.Roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


@Database( entities = {RoomData.class},version = 1)

public  abstract class RoomDataBaseClass  extends RoomDatabase {

    private static RoomDataBaseClass instance;

    public abstract RoomDao roomDao();

    public static synchronized RoomDataBaseClass getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDataBaseClass.class, "ROOM-database")
                    .enableMultiInstanceInvalidation()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class PopulateDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private RoomDao mroomDao;

        PopulateDataAsyncTask(RoomDataBaseClass roomDatabaseClass) {
            mroomDao = roomDatabaseClass.roomDao();

        }


        @Override
        protected Void doInBackground(Void... voids) {
            mroomDao.insert(new RoomData("",""));

            return null;
        }
    }
}
