package com.archstud.architecturestudyapp.repository;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataObjectRepository {

    private final DataObjectDatabase database = DataObjectDatabase.getInstance();
    private DataObject result;

    public void create(DataObject dataObject){
        database.dataObjectDAO().insertOrUpdateUser(dataObject)
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    public DataObject read(String dataObjectName){
        database.dataObjectDAO().read(dataObjectName)
                .subscribeOn(Schedulers.io())
                .subscribe(new MaybeObserver<DataObject>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull DataObject dataObject) {
                    result = dataObject;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return result;
    }

    public void update(String dataObjectName, DataObject dataObject){
        database.dataObjectDAO().insertOrUpdateUser(dataObject)
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    public void delete(DataObject dataObject){
        database.dataObjectDAO().delete(dataObject)
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}
