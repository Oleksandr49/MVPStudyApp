package com.archstud.architecturestudyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.Adapter;
import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.repository.DataObjectRepositoryImpl;


public class ListFragment extends Fragment implements ListPresenter.View {

    private ListPresenter presenter;
    private RecyclerView recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListPresenter();
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
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new Adapter(presenter));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.initListItems();
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }

    public void showDialog(int position){
        ConfirmationDialog dialog = new ConfirmationDialog(presenter, position);
        dialog.show(getFragmentManager(), "anyTag");
    }

    @Override
    public Adapter getViewAdapter() {
        return (Adapter) recyclerView.getAdapter();
    }

    public Presenter getPresenter(){
        return this.presenter;
    }
}
