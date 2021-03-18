package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.views.interfaces.BaseView;
import com.archstud.architecturestudyapp.model.repository.BaseRepository;

public abstract class BasePresenter <T> {

    protected BaseView baseView;
    protected BaseRepository<T> repository;

    protected Boolean isViewNull(){
        return baseView == null;
    }

    public void setView(BaseView baseView) {
        this.baseView = baseView;
    }

    public void setRepository(BaseRepository<T> repository) {
        this.repository = repository;
    }


}
