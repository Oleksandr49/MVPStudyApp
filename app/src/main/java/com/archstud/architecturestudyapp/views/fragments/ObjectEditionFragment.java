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

import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.model.repository.DataObjectRepository;
import com.archstud.architecturestudyapp.presenters.ObjectEditionFragmentPresenter;
import com.archstud.architecturestudyapp.views.interfaces.BaseView;
import com.archstud.architecturestudyapp.views.interfaces.DataObjectDisplay;

public class ObjectEditionFragment extends BaseFragment implements BaseView, DataObjectDisplay {

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
        cancelButton.setOnClickListener(v -> dismissFragment());
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        presenter.initEditionFields();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }

    public void setAssociatedObjectId(Long associatedObjectId) {
        this.associatedObjectId = associatedObjectId;
    }

    @Override
    public void setName(String name) {
        this.editName.setText(name);
    }

    @Override
    public void setDetails(String details) {
        this.editDetails.setText(details);
    }
}
