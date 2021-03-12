package com.archstud.architecturestudyapp;

public interface PresenterListener {

    void showRemovalConfirmationDialog(int position);
    void deleteObjectFromDatabase(Long dataObjectId);
}
