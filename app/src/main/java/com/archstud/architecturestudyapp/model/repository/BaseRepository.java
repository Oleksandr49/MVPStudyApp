package com.archstud.architecturestudyapp.model.repository;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface BaseRepository <T> {

    Single<List<T>> readAll();
    Completable create(T object);
    Single<DataObject> read(Long objectId);
    Completable update (T object);
    Completable delete(T object);
    Completable deleteById(Long objectId);
}
