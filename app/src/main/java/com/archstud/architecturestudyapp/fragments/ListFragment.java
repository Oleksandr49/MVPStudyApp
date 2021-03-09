package com.archstud.architecturestudyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.repository.DataObject;


public class ListFragment extends Fragment implements ListFragmentPresenter.View {

    private ListFragmentPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListFragmentPresenter();
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
        recyclerView.setAdapter(presenter.getAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();

                if (manager == null)
                    return;

                int totalItemCount = manager.getItemCount();
                int lastVisibleItemPosition = 0;
                int firstVisibleItemPosition = 0;

                if(manager instanceof LinearLayoutManager){
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) manager;
                    lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                }
                if(manager instanceof GridLayoutManager){
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
                    lastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                    firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                }

                if (totalItemCount - lastVisibleItemPosition < ((lastVisibleItemPosition - firstVisibleItemPosition)*2)) {
                    //presenter.loadMore();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }

    public void updateList(DataObject object){
        presenter.updateList(object);
    }
}
