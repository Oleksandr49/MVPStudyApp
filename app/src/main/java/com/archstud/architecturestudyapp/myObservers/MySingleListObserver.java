package com.archstud.architecturestudyapp.myObservers;

import com.archstud.architecturestudyapp.repository.DataObject;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MySingleListObserver implements SingleObserver<List<DataObject>> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onSuccess(@NonNull List<DataObject> dataObjects) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
