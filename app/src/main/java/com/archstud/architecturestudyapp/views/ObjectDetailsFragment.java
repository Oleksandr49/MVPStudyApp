package com.archstud.architecturestudyapp.views;

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

import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.model.repository.DataObjectRepository;
import com.archstud.architecturestudyapp.presenters.ObjectDetailsFragmentPresenter;
import com.archstud.architecturestudyapp.views.interfaces.BaseView;

public class ObjectDetailsFragment extends Fragment implements BaseView {

    private TextView name;
    private TextView details;
    private ObjectDetailsFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ObjectDetailsFragmentPresenter();
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
        Button updateButton = view.findViewById(R.id.updateButton);
        Button closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> presenter.dismissFragment());
        name = view.findViewById(R.id.objectName);
        details = view.findViewById(R.id.details);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }

    @Override
    public void showToast(String text) {

    }

    @Override
    public void showDialog(DialogFragment dialog) {

    }

    @Override
    public void dismissView() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setDetails(String details) {
        this.details.setText(details);
    }
}
