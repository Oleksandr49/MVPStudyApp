package com.archstud.architecturestudyapp.repository;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface DataObjectDAO {

    @Delete
    Completable delete(DataObject dataObject);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insertOrUpdateUser(DataObject dataObject);

    @Query("SELECT * FROM DataObjects WHERE id = :dataObjectId")
    Maybe<DataObject> read(Long dataObjectId);

    @Query("SELECT * FROM DataObjects")
    Single<List<DataObject>> readAll();

    @Query("DELETE FROM DataObjects WHERE id = :dataObjectId")
    Completable deleteById(Long dataObjectId);
}
