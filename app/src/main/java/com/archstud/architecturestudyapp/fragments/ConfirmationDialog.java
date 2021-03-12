package com.archstud.architecturestudyapp.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class ConfirmationDialog extends DialogFragment {

    ListFragmentPresenter.ConfirmationDialogCallBack confirmationDialogCallBack;

    public ConfirmationDialog(ListFragmentPresenter.ConfirmationDialogCallBack confirmationDialogCallBack){
        this.confirmationDialogCallBack = confirmationDialogCallBack;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Confirm please")
                .setPositiveButton("Confirm", (dialog, id) -> confirmationDialogCallBack.onConfirm())
                .setNegativeButton("Cancel", (dialog, id) -> dialog.dismiss());
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
