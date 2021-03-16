package com.archstud.architecturestudyapp.model.repository;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface BaseRepository <T> {

    Single<List<T>> readAll();
    Completable create(T dataObject);
    Single<DataObject> read(Long dataObjectId);
    Completable update (T dataObject);
    Completable delete(T dataObject);
    Completable deleteById(Long dataObjectId);
}
