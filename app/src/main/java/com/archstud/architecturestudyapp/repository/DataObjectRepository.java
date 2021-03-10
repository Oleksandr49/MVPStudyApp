package com.archstud.architecturestudyapp.repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class DataObjectRepository {

    private final DataObjectDatabase database = DataObjectDatabase.getInstance();

    public Single<List<DataObject>> readAll(){
        return database.dataObjectDAO().readAll();
    }

    public Completable create(DataObject dataObject){
        return database.dataObjectDAO().insertOrUpdateUser(dataObject);
    }

    public Maybe<DataObject> read(String dataObjectName){
        return database.dataObjectDAO().read(dataObjectName);
    }

    public Completable update(DataObject dataObject){
        return database.dataObjectDAO().insertOrUpdateUser(dataObject);
    }

    public Completable delete(DataObject dataObject){
        return database.dataObjectDAO().delete(dataObject);
    }

}
