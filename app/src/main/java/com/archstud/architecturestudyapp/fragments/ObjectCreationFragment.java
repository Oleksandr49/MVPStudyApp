package com.archstud.architecturestudyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.archstud.architecturestudyapp.MainActivity;
import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.repository.DataObject;

public class ObjectCreationFragment extends Fragment implements ObjectCreationFragmentPresenter.View{

    private ObjectCreationFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ObjectCreationFragmentPresenter();
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

        addButton.setOnClickListener(v -> {
            DataObject object = new DataObject();
            object.setName(objectNameInput.getText().toString());
            object.setDetails(objectDetailsInput.getText().toString());
            presenter.addObject(object);
            FragmentCommander commander = (MainActivity)getActivity();

            if(commander!=null){
                commander.updateListFragment(object);
                commander.hideFragment(this);
            }

        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }

    public interface FragmentCommander {
        void hideFragment(Fragment fragment);
        void updateListFragment(DataObject dataObject);
    }

}
