package com.archstud.architecturestudyapp.views.interfaces;


import com.archstud.architecturestudyapp.presenters.ListFragmentPresenterListener;

import java.util.List;

public interface AdapterListener<T> {

    void setPresenterListener(ListFragmentPresenterListener<T> listener);
    void updateAdapter(List<T> updatedData);
}
