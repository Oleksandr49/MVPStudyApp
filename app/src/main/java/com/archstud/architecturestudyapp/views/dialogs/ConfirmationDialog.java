package com.archstud.architecturestudyapp.views.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class ConfirmationDialog extends DialogFragment {

   ConfirmationDialogCallback confirmationDialogCallBack;

    public ConfirmationDialog(ConfirmationDialogCallback confirmationDialogCallBack){
        this.confirmationDialogCallBack = confirmationDialogCallBack;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Confirm please")
                .setPositiveButton("Confirm", (dialog, id) -> confirmationDialogCallBack.onConfirm())
                .setNegativeButton("Cancel", (dialog, id) -> dialog.dismiss());
        return builder.create();
    }
}
