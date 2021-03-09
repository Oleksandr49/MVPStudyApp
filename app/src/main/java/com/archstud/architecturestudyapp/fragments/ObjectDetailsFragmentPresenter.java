package com.archstud.architecturestudyapp.fragments;

import com.archstud.architecturestudyapp.repository.DataObjectRepository;

public class ObjectDetailsFragmentPresenter {
    private View view;
    private final DataObjectRepository repository = new DataObjectRepository();

    public void setView(View view){
        this.view = view;
    }

    public interface View{

    }
}
