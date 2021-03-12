package com.archstud.architecturestudyapp.repository;

import com.archstud.architecturestudyapp.fragments.DataObjectPresenter;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface DataObjectRepository {

     Single<List<DataObject>> readAll();
     Single<Long> create(DataObject dataObject);
     Maybe<DataObject> read(Long dataObjectId);
     //Completable update (DataObject dataobject);
     Completable delete(DataObject dataObject);
     Completable deleteById(Long dataObjectId);
}
