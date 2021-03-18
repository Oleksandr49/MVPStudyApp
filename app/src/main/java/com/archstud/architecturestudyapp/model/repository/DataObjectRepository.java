package com.archstud.architecturestudyapp.model.repository;

import com.archstud.architecturestudyapp.model.database.DataObjectDatabase;
import com.archstud.architecturestudyapp.model.domainModels.DataObject;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;


public class DataObjectRepository implements BaseRepository<DataObject> {

    private final DataObjectDatabase database = DataObjectDatabase.getInstance();

    @Override
    public Single<List<DataObject>> readAll() {
        return database.dataObjectDAO().readAll();
    }

    @Override
    public Completable create(DataObject dataObject) {
        return database.dataObjectDAO().insertOrUpdateUser(dataObject);
    }

    @Override
    public Single<DataObject> read(Long dataObjectId) {
        return database.dataObjectDAO().read(dataObjectId);
    }


    @Override
    public Completable update(DataObject dataobject) {
        return database.dataObjectDAO().insertOrUpdateUser(dataobject);
    }


    @Override
    public Completable delete(DataObject dataObject) {
        return database.dataObjectDAO().delete(dataObject);
    }

    @Override
    public Completable deleteById(Long dataObjectId) {
        return database.dataObjectDAO().deleteById(dataObjectId);
    }
}
