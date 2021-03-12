package com.archstud.architecturestudyapp.fragments;

import com.archstud.architecturestudyapp.myObservers.MyCompletableObserver;
import com.archstud.architecturestudyapp.repository.DataObject;
import com.archstud.architecturestudyapp.repository.DataObjectRepository;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ObjectCreationFragmentPresenter extends DataObjectPresenter {

    private View view;
    private DataObjectRepository repository;

    public void setView(View view){
        this.view = view;
    }

    public void addPositionToDatabase(String name, String details){
        DataObject dataObject = new DataObject();
        dataObject.setName(name);
        dataObject.setDetails(details);

        repository.create(dataObject)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Long aLong) {
                view.addPositionToAdapter(aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    public void setRepository(DataObjectRepository repository) {
        this.repository = repository;
    }

    public interface View {
        void addPositionToAdapter(Long dataObjectId);
    }


}
