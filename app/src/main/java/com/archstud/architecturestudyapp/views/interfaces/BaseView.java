package com.archstud.architecturestudyapp.views.interfaces;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


public interface BaseView {
    void showToast(String text);
    void showDialog(DialogFragment dialog);
    void showFragment(Fragment fragment);
    void dismissView();
}
