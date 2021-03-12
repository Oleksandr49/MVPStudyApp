package com.archstud.architecturestudyapp.fragments;

import androidx.fragment.app.DialogFragment;

public interface View {
    void showToast(String text);
    void showDialog(DialogFragment dialog);
}
