package com.archstud.architecturestudyapp.myObservers;

import com.archstud.architecturestudyapp.repository.DataObject;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MySingleObserver implements SingleObserver<DataObject> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onSuccess(@NonNull DataObject dataObject) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
