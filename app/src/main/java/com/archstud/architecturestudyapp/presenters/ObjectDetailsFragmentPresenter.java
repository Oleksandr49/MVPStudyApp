package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;

public class ObjectDetailsFragmentPresenter extends BasePresenter<DataObject> {

    public void dismissFragment(){
        baseView.dismissView();
    }

}
