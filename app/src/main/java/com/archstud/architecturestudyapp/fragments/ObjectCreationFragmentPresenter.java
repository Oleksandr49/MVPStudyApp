package com.archstud.architecturestudyapp.fragments;

import com.archstud.architecturestudyapp.repository.DataObject;
import com.archstud.architecturestudyapp.repository.DataObjectRepository;

public class ObjectCreationFragmentPresenter {

    private View view;
    private final DataObjectRepository repository = new DataObjectRepository();

    public void setView(View view){
        this.view = view;
    }

    public void addObject(DataObject dataObject){
        repository.create(dataObject);
    }

    public interface View{

    }
}
