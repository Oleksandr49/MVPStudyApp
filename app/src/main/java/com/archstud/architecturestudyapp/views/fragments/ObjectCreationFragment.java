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
import com.archstud.architecturestudyapp.presenters.ObjectCreationFragmentPresenter;
import com.archstud.architecturestudyapp.views.interfaces.BaseView;

import java.util.Objects;

public class ObjectCreationFragment extends BaseFragment implements BaseView {

    private ObjectCreationFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ObjectCreationFragmentPresenter();
        presenter.setRepository(new DataObjectRepository());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter.setView(this);
        return inflater.inflate(R.layout.object_creation_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        EditText objectNameInput = view.findViewById(R.id.objectNameInput);
        EditText objectDetailsInput = view.findViewById(R.id.objectDetailsInput);

        Button addButton = view.findViewById(R.id.ADD);
        addButton.setOnClickListener(v ->{
            String name = objectNameInput.getText().toString();
            String details = objectDetailsInput.getText().toString();
                presenter.addPositionToDatabase(name, details);
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }
}
