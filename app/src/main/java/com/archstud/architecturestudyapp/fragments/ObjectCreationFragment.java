package com.archstud.architecturestudyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.repository.DataObjectRepositoryImpl;

public class ObjectCreationFragment extends Fragment implements ObjectCreationFragmentPresenter.View{

    private ObjectCreationFragmentPresenter presenter;
    private FragmentListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ObjectCreationFragmentPresenter();
        presenter.setRepository(new DataObjectRepositoryImpl());
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
            if(!objectNameInput.getText().toString().isEmpty() & !objectDetailsInput.getText().toString().isEmpty()){
                presenter.addPositionToDatabase(objectNameInput.getText().toString(), objectDetailsInput.getText().toString()); }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }

    @Override
    public FragmentListener getFragmentListener(){
        return this.listener;
    }

    @Override
    public void dismissFragment() {
        listener.removeFragment(this);
    }

    public void setListener(FragmentListener listener) {
        this.listener = listener;
    }

    public interface FragmentListener{
        void removeFragment(Fragment fragment);
        void addPositionToList(String positionName);
    }
}
