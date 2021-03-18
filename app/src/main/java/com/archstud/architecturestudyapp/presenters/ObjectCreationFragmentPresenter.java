package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;
import com.archstud.architecturestudyapp.model.observers.OnCompleteObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ObjectCreationFragmentPresenter extends BasePresenter<DataObject> {


    public void addPositionToDatabase(String name, String details){
        DataObject dataObject;
        if(isValid(name, details)){
            dataObject = new DataObject(name, details);
            repository.create(dataObject)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new OnCompleteObserver(() -> baseView.dismissFragment()));
        }
    }

    private Boolean isValid(String name, String details){
        return (!name.isEmpty() && !details.isEmpty());
    }
}
