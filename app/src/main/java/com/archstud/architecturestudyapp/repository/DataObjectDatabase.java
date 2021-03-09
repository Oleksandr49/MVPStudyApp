package com.archstud.architecturestudyapp.repository;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.archstud.architecturestudyapp.MyApplication;

@Database(entities = DataObject.class, exportSchema = false, version = 1)
public abstract class DataObjectDatabase extends RoomDatabase {

    private static final String DB_Name = "DataObjectsDatabase";
    private static DataObjectDatabase instance;

    public static synchronized DataObjectDatabase getInstance(){
        if(instance == null){
            instance = Room.databaseBuilder(MyApplication.getAppContext(), DataObjectDatabase.class, DB_Name)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract DataObjectDAO dataObjectDAO();

}
