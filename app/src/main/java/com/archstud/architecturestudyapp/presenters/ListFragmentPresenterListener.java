package com.archstud.architecturestudyapp.presenters;

import com.archstud.architecturestudyapp.views.dialogs.ConfirmationDialogCallback;


public interface ListFragmentPresenterListener<T> {

     void showRemovalConfirmationDialog(ConfirmationDialogCallback callback);
     void deleteObjectFromDatabase(Long id);
     void showDetails();
}
