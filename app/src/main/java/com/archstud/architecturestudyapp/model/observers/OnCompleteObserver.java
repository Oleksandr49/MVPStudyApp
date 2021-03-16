package com.archstud.architecturestudyapp.model.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class OnCompleteObserver implements CompletableObserver {

    private OnCompleteActionCallback callback;

    public OnCompleteObserver(OnCompleteActionCallback callback){
        this.callback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onComplete() {
        callback.onCompleteDo();
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
