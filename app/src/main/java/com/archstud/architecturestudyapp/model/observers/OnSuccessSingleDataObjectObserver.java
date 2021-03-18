package com.archstud.architecturestudyapp.model.observers;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class OnSuccessSingleDataObjectObserver implements SingleObserver<DataObject> {

    private OnSuccessActionCallback<DataObject> callback;

    public OnSuccessSingleDataObjectObserver(OnSuccessActionCallback<DataObject> callback){
        this.callback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onSuccess(@NonNull DataObject dataObject) {
        callback.onSuccessDo(dataObject);
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
