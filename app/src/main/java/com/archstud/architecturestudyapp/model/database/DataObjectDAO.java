package com.archstud.architecturestudyapp.model.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface DataObjectDAO {

    @Delete
    Completable delete(DataObject dataObject);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertOrUpdateUser(DataObject dataObject);

    @Query("SELECT * FROM DataObjects WHERE id = :dataObjectId")
    Single<DataObject> read(Long dataObjectId);

    @Query("SELECT * FROM DataObjects")
    Single<List<DataObject>> readAll();

    @Query("DELETE FROM DataObjects WHERE id = :dataObjectId")
    Completable deleteById(Long dataObjectId);
}
