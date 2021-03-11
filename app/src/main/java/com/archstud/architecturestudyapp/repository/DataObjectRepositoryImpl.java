package com.archstud.architecturestudyapp.repository;

import com.archstud.architecturestudyapp.fragments.ListPresenter;
import com.archstud.architecturestudyapp.fragments.ObjectCreationFragmentPresenter;
import com.archstud.architecturestudyapp.fragments.Presenter;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataObjectRepositoryImpl implements DataObjectRepository {

    private final DataObjectDatabase database = DataObjectDatabase.getInstance();

    @Override
    public void readAll(Presenter presenterCallback) {
         database.dataObjectDAO().readAll()
                .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<DataObject>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<DataObject> dataObjects) {
                        ((ListPresenter)presenterCallback).loadToAdapter(dataObjects);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    @Override
    public void create(DataObject dataObject, Presenter presenterCallback){
        database.dataObjectDAO().insertOrUpdateUser(dataObject)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                ((ObjectCreationFragmentPresenter)presenterCallback).addPositionToList(dataObject.getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    @Override
    public void read(String dataObjectName, Presenter presenterCallback){
         database.dataObjectDAO().read(dataObjectName)
                .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<DataObject>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull DataObject dataObject) {
                        ((ListPresenter)presenterCallback).addPositionToAdapter(dataObject);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void update(DataObject dataObject, Presenter presenterCallback){
        database.dataObjectDAO().insertOrUpdateUser(dataObject)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    @Override
    public void delete(DataObject dataObject, Presenter presenterCallback){
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

    @Override
    public void deleteByName(String dataObjectName, Presenter presenterCallBack) {
        database.dataObjectDAO().read(dataObjectName)
                .subscribeOn(Schedulers.io())
                .subscribe(new MaybeObserver<DataObject>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull DataObject dataObject) {
                        delete(dataObject, presenterCallBack);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
