package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;
import com.archstud.architecturestudyapp.model.observers.OnCompleteObserver;
import com.archstud.architecturestudyapp.model.observers.OnSuccessSingleDataObjectObserver;
import com.archstud.architecturestudyapp.views.interfaces.DataObjectDisplay;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ObjectEditionFragmentPresenter extends BasePresenter<DataObject> {

    private Long associatedObjectId;
    private DataObjectDisplay dataObjectDisplay;
    private DataObject associatedObject;

    public void initEditionFields(){
        setDataObjectDisplay((DataObjectDisplay) baseView);
        repository.read(associatedObjectId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OnSuccessSingleDataObjectObserver(object -> {
                    associatedObject = object;
                    dataObjectDisplay.setName(object.getName());
                    dataObjectDisplay.setDetails(object.getDetails());
                }));
    }

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
        if(!isSameData(name, details)) return (!name.isEmpty() && !details.isEmpty());
        return false;
    }

    private Boolean isSameData(String name, String details){
        return (name.equals(associatedObject.getName()) && details.equals(associatedObject.getDetails()));
    }

    public void setAssociatedObjectId(Long associatedObjectId){
        this.associatedObjectId = associatedObjectId;
    }

    public void dismissFragment(){
        baseView.dismissFragment();
    }

    private void setDataObjectDisplay(DataObjectDisplay dataObjectDisplay) {
        this.dataObjectDisplay = dataObjectDisplay;
    }
}
