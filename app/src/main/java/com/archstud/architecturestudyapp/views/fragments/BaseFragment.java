package com.archstud.architecturestudyapp.views.fragments;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.archstud.architecturestudyapp.R;

import java.util.Objects;

public class BaseFragment extends Fragment {

    public void showFragment(Fragment fragment) {
            FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentPlaceHolder, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
    }

    public void dismissFragment(){
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
    }

    public void showDialog(DialogFragment dialog) {
        if(getFragmentManager() != null) dialog.show(getFragmentManager(), "anyTag");
    }
}
