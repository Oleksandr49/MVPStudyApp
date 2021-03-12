package com.archstud.architecturestudyapp.myObservers;

import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MyCompletableObserver implements CompletableObserver {


    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
