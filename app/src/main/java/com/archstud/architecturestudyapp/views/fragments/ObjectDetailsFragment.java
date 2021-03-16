package com.archstud.architecturestudyapp.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.model.repository.DataObjectRepository;
import com.archstud.architecturestudyapp.presenters.ObjectDetailsFragmentPresenter;
import com.archstud.architecturestudyapp.views.interfaces.BaseView;
import com.archstud.architecturestudyapp.views.interfaces.DataObjectDisplay;

public class ObjectDetailsFragment extends Fragment implements BaseView, DataObjectDisplay {

    private TextView name;
    private TextView details;
    private ObjectDetailsFragmentPresenter presenter;
    private Long associatedObjectId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ObjectDetailsFragmentPresenter();
        presenter.setDataObjectDisplay(this);
        presenter.setAssociatedObjectId(associatedObjectId);
        presenter.setRepository(new DataObjectRepository());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter.setView(this);
        return inflater.inflate(R.layout.object_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button editButton = view.findViewById(R.id.editButton);
        editButton.setOnClickListener(v -> {
            ObjectEditionFragment objectEditionFragment = new ObjectEditionFragment();
            objectEditionFragment.setAssociatedObjectId(associatedObjectId);
            showFragment(objectEditionFragment);
        });
        Button closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> presenter.dismissFragment());
        this.name = view.findViewById(R.id.name);
        this.details = view.findViewById(R.id.details);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        presenter.initData();
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

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }

    @Override
    public void setDetails(String details) {
        this.details.setText(details);
    }

    @Override
    public void setAssociatedObjectId(Long associatedObjectId) {
        this.associatedObjectId = associatedObjectId;
    }
}
