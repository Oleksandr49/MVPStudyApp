package com.archstud.architecturestudyapp.views.interfaces;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


public interface BaseView {
    void showDialog(DialogFragment dialog);
    void showFragment(Fragment fragment);
    void dismissView();
}
