package com.archstud.architecturestudyapp.fragments;

import com.archstud.architecturestudyapp.repository.DataObject;
import com.archstud.architecturestudyapp.repository.DataObjectRepository;


public class ObjectCreationFragmentPresenter implements Presenter {

    private View view;
    private DataObjectRepository repository;

    public void setView(View view){
        this.view = view;
    }

    public void addPositionToDatabase(String name, String details){
        DataObject dataObject = new DataObject();
        dataObject.setName(name);
        dataObject.setDetails(details);
        repository.create(dataObject, this);
    }

    public void addPositionToList(String positionName){
       ObjectCreationFragment.FragmentListener listener = view.getFragmentListener();
       listener.addPositionToList(positionName);
       view.dismissFragment();
    }

    public void setRepository(DataObjectRepository repository) {
        this.repository = repository;
    }

    public interface View {
        ObjectCreationFragment.FragmentListener getFragmentListener();
        void dismissFragment();
    }
}
