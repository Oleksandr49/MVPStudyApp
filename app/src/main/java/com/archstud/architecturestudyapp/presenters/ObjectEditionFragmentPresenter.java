package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;
import com.archstud.architecturestudyapp.model.observers.OnCompleteObserver;

import io.reactivex.schedulers.Schedulers;

public class ObjectEditionFragmentPresenter extends BasePresenter<DataObject> {

    private Long associatedObjectId;

    public void update(String name, String details){
        if(isDataValid(name, details)){
            DataObject updatedObject = new DataObject(name, details);
            updatedObject.setId(associatedObjectId);
            repository.update(updatedObject)
                    .subscribeOn(Schedulers.io())
                    .subscribe(new OnCompleteObserver(this::dismissFragment));
        }
    }

    private Boolean isDataValid(String name, String details){
        if(!name.equals("EditName") && !details.equals("EditDetails")){
            return (!name.isEmpty() && !details.isEmpty());
        }
        return false;
    }

    public void setAssociatedObjectId(Long associatedObjectId){
        this.associatedObjectId = associatedObjectId;
    }

    public void dismissFragment(){
        baseView.dismissView();
    }
}
