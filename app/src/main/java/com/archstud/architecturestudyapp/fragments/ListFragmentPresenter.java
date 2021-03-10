package com.archstud.architecturestudyapp.fragments;


import com.archstud.architecturestudyapp.Adapter;
import com.archstud.architecturestudyapp.repository.DataObjectRepository;



public class ListFragmentPresenter {

    private View view;
    private final Adapter adapter = new Adapter();
    private final DataObjectRepository repository = new DataObjectRepository();

    public void setView(View view) {
        this.view = view;
    }

    public Adapter getAdapter(){
        return this.adapter;
    }

    public interface View {
    }







}
