package com.archstud.architecturestudyapp.model.observers;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class OnSuccessSingleDataObjectListObserver implements SingleObserver<List<DataObject>> {

    private final OnSuccessActionCallback<List<DataObject>> callback;

    public OnSuccessSingleDataObjectListObserver(OnSuccessActionCallback<List<DataObject>> callback){
        this.callback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onSuccess(@NonNull List<DataObject> dataObjects) {
        callback.onSuccessDo(dataObjects);
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
