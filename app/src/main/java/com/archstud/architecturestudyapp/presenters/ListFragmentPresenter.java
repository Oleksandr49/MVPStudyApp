package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.model.observers.OnCompleteObserver;
import com.archstud.architecturestudyapp.views.ObjectDetailsFragment;
import com.archstud.architecturestudyapp.views.dialogs.ConfirmationDialogCallback;
import com.archstud.architecturestudyapp.views.dialogs.ConfirmationDialog;
import com.archstud.architecturestudyapp.model.domainModels.DataObject;
import com.archstud.architecturestudyapp.model.observers.OnSuccessSingleListObserver;
import com.archstud.architecturestudyapp.views.interfaces.AdapterListener;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ListFragmentPresenter extends BasePresenter<DataObject> implements ListFragmentPresenterListener<DataObject> {

    private AdapterListener<DataObject> adapterListener;

    public void deleteObjectFromDatabase(Long dataObjectId) {
        repository.deleteById(dataObjectId)
                .subscribeOn(Schedulers.io())
                .subscribe(new OnCompleteObserver(this::updateAdapter));
    }

    @Override
    public void showRemovalConfirmationDialog(ConfirmationDialogCallback confirmationDialogCallback){
        if(!isViewNull()) baseView.showDialog(new ConfirmationDialog(confirmationDialogCallback));
    }

    public void setAdapterListener(AdapterListener<DataObject> adapterListener) {
        this.adapterListener = adapterListener;
    }

    public void updateAdapter(){
        repository.readAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OnSuccessSingleListObserver(objects -> adapterListener.updateAdapter(objects)));
    }

    @Override
    public void showDetails() {
    }
}
