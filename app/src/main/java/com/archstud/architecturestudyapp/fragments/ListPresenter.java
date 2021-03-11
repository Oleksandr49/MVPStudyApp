package com.archstud.architecturestudyapp.fragments;


import com.archstud.architecturestudyapp.Adapter;
import com.archstud.architecturestudyapp.repository.DataObject;
import com.archstud.architecturestudyapp.repository.DataObjectRepository;

import java.util.List;


public class ListPresenter implements Presenter {

    private View view;
    private DataObjectRepository repository;

    public void setView(View view) {
        this.view = view;
    }

    public void setRepository(DataObjectRepository repository) {
        this.repository = repository;
    }

    public void initListItems(){
        repository.readAll(this);
    }

    public void addPositionToAdapter(DataObject dataObject){
        view.getViewAdapter().addItem(dataObject);
    }

    public void loadToAdapter(List<DataObject> dataObjects) {
        view.getViewAdapter().initListItems(dataObjects);
    }

    public void showDetails(String objectName){

    }

    public void removePositionFromAdapter(int position){
        view.getViewAdapter().removePosition(position);
    }

    public void removePositionFromDatabase(String dataObjectName){
        repository.deleteByName(dataObjectName, this);
    }

    public void showConfirmationDialog(int position){
        view.showDialog(position);
    }

    public interface View {
        Adapter getViewAdapter();
        void showDialog(int position);
    }

    public void addPositionToList(String positionName){
        repository.read(positionName, this);
    }








}
