package com.archstud.architecturestudyapp.fragments;

import com.archstud.architecturestudyapp.repository.DataObject;
import com.archstud.architecturestudyapp.repository.DataObjectRepository;

import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ObjectCreationFragmentPresenter {

    private View view;
    private final DataObjectRepository repository = new DataObjectRepository();

    public void setView(View view){
        this.view = view;
    }

    public void addObject(DataObject dataObject){
        repository.create(dataObject)
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

    public interface View{
    }
}
