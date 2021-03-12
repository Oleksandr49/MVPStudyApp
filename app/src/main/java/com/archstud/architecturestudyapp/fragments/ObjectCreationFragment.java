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
    private ListViewFragment listViewFragment;
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
            String name = objectNameInput.getText().toString();
            String details = objectDetailsInput.getText().toString();
            if(!name.isEmpty() & !details.isEmpty()){
                presenter.addPositionToDatabase(name, details); }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        listViewFragment = null;
        listener = null;
        super.onDestroy();
    }

    @Override
    public void addPositionToAdapter(Long dataObjectId) {
        listViewFragment.addPosition(dataObjectId);
        listener.removeFragment(this);
    }

    public void setListener(FragmentListener listener) {
        this.listener = listener;
    }

    public void setListViewFragment(ListViewFragment listViewFragment) {
        this.listViewFragment = listViewFragment;
    }

    public interface FragmentListener{
        void removeFragment(Fragment fragment);
    }
}
