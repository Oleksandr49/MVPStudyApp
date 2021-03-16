package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;
import com.archstud.architecturestudyapp.model.observers.OnSuccessSingleDataObjectObserver;
import com.archstud.architecturestudyapp.views.interfaces.DataObjectDisplay;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ObjectDetailsFragmentPresenter extends BasePresenter<DataObject> {

    private Long associatedObjectId;
    private DataObjectDisplay dataObjectDisplay;

    public void initData(){
        repository.read(associatedObjectId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OnSuccessSingleDataObjectObserver(object -> {
                    dataObjectDisplay.setName(object.getName());
                    dataObjectDisplay.setDetails(object.getDetails());
                }));
    }

    public void setAssociatedObjectId(Long associatedObjectId){
        this.associatedObjectId = associatedObjectId;
    }

    public void dismissFragment(){
        baseView.dismissView();
    }

    public void setDataObjectDisplay(DataObjectDisplay dataObjectDisplay) {
        this.dataObjectDisplay = dataObjectDisplay;
    }
}
