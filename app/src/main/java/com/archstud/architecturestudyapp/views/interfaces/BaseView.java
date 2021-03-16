package com.archstud.architecturestudyapp.views.interfaces;

import androidx.fragment.app.DialogFragment;


public interface BaseView {
    void showToast(String text);
    void showDialog(DialogFragment dialog);
    void dismissView();
}
