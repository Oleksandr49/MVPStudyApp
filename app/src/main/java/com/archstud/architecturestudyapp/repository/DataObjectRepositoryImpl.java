package com.archstud.architecturestudyapp.repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;


public class DataObjectRepositoryImpl implements DataObjectRepository {

    private final DataObjectDatabase database = DataObjectDatabase.getInstance();

    @Override
    public Single<List<DataObject>> readAll() {
        return database.dataObjectDAO().readAll();
    }

    @Override
    public Single<Long> create(DataObject dataObject) {
        return database.dataObjectDAO().insertOrUpdateUser(dataObject);
    }

    @Override
    public Maybe<DataObject> read(Long dataObjectId) {
        return database.dataObjectDAO().read(dataObjectId);
    }

    /*
    @Override
    public Single<Long> update(DataObject dataobject) {
        return database.dataObjectDAO().insertOrUpdateUser(dataobject);
    }

     */

    @Override
    public Completable delete(DataObject dataObject) {
        return database.dataObjectDAO().delete(dataObject);
    }

    @Override
    public Completable deleteById(Long dataObjectId) {
        return database.dataObjectDAO().deleteById(dataObjectId);
    }
}
