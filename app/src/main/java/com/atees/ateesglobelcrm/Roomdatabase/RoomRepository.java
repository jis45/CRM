package com.atees.ateesglobelcrm.Roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomRepository {

    private  RoomDao mroomDao;

    private LiveData<List<RoomData>>getAlldatabase;

    public  RoomRepository(Application app){
        RoomDataBaseClass dataBaseClass=RoomDataBaseClass.getInstance(app);
        mroomDao=dataBaseClass.roomDao();
        getAlldatabase=mroomDao.getAlldatabase();


    }
    public  void insert(RoomData roomData){

        new InsertAsyncTask(mroomDao).execute(roomData);

    }

    //delete

    public  void  delete(RoomData roomData){
        new DeleteAsyncTask(mroomDao).execute(roomData);

    }

    //update
    public  void  update(RoomData roomData){
        new  UpdateAsyncTask(mroomDao).execute(roomData);

    }

    //getallwords

    public LiveData<List<RoomData>>getAlldatabase() {
        return getAlldatabase;
    }

    //detete all words

    public  void  deleteAlldatabase(){
        new DeieteAllwordAsyncTask(mroomDao).execute();

    }
    private  static  class  InsertAsyncTask extends AsyncTask<RoomData, Void,Void> {
        private  RoomDao mroomDao;
        private  InsertAsyncTask(RoomDao roomDao){
            mroomDao=roomDao;
        }
        @Override
        protected Void doInBackground(RoomData... roomData) {
            mroomDao.insert(roomData[0]);
            return null;
        }
    }
    private  static  class  DeleteAsyncTask extends AsyncTask<RoomData, Void,Void> {
        private RoomDao mroomDao;

        private DeleteAsyncTask(RoomDao roomDao) {
            mroomDao = roomDao;
        }
        @Override
        protected Void doInBackground(RoomData... roomData) {

            mroomDao.delete(roomData[0]);
            return null;
        }
    }

    private  static  class  UpdateAsyncTask extends AsyncTask<RoomData, Void,Void>{

        private RoomDao mroomDao;
        private  UpdateAsyncTask(RoomDao roomDao){
            mroomDao = roomDao;
        }
        @Override
        protected Void doInBackground(RoomData... roomData) {
            mroomDao.update(roomData[0]);
            return null;
        }
    }
    private  static  class  DeieteAllwordAsyncTask extends AsyncTask<Void, Void,Void>{
        private RoomDao mroomDao;
        private  DeieteAllwordAsyncTask(RoomDao roomDao){
            mroomDao = roomDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mroomDao.deleteAlldatabase();
            return null;
        }
    }
}
