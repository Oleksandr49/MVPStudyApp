package com.archstud.architecturestudyapp.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.model.repository.DataObjectRepository;
import com.archstud.architecturestudyapp.presenters.ObjectEditionFragmentPresenter;
import com.archstud.architecturestudyapp.views.interfaces.BaseView;

public class ObjectEditionFragment extends Fragment implements BaseView {

    private ObjectEditionFragmentPresenter presenter;
    private Long associatedObjectId;
    private EditText editName;
    private EditText editDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ObjectEditionFragmentPresenter();
        presenter.setRepository(new DataObjectRepository());
        presenter.setAssociatedObjectId(associatedObjectId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter.setView(this);
        return inflater.inflate(R.layout.object_edition_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button confirmButton = view.findViewById(R.id.Confirm);
        Button cancelButton = view.findViewById(R.id.Cancel);
        editName = view.findViewById(R.id.objectNameEdit);
        editDetails = view.findViewById(R.id.objectDetailsEdit);
        confirmButton.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String details = editDetails.getText().toString();
            presenter.update(name, details);
        });
        cancelButton.setOnClickListener(v -> dismissView());
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }


    @Override
    public void showDialog(DialogFragment dialog) {

    }

    @Override
    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentPlaceHolder, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void dismissView() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    public void setAssociatedObjectId(Long associatedObjectId) {
        this.associatedObjectId = associatedObjectId;
    }
}
