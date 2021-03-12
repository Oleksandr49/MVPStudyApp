package com.archstud.architecturestudyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.Adapter;
import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.repository.DataObjectRepositoryImpl;


public class ListFragment extends Fragment implements com.archstud.architecturestudyapp.fragments.View, ListViewFragment {

    private ListFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListFragmentPresenter();
        presenter.setRepository(new DataObjectRepositoryImpl());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter.setView(this);
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter();
        adapter.setPresenterListener(presenter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.setAdapterListener(adapter);
        presenter.initListItems();
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void showDialog(DialogFragment dialog){
        if(getFragmentManager() != null) dialog.show(getFragmentManager(), "anyTag");
    }

    @Override
    public void addPosition(Long dataObjectId) {
        presenter.addPositionToAdapter(dataObjectId);
    }
}
