package com.archstud.architecturestudyapp.views.fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.model.repository.DataObjectRepository;
import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.presenters.ListFragmentPresenter;
import com.archstud.architecturestudyapp.views.adapters.ListFragmentAdapter;
import com.archstud.architecturestudyapp.views.interfaces.BaseView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;


public class ObjectListFragment extends BaseFragment implements BaseView {

    private ListFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListFragmentPresenter();
        presenter.setRepository(new DataObjectRepository());
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
        ListFragmentAdapter listFragmentAdapter = new ListFragmentAdapter();
        listFragmentAdapter.setPresenterListener(presenter);
        recyclerView.setAdapter(listFragmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.left = 10;
                outRect.right = 10;
                outRect.bottom = 15;
                outRect.top = 15;
            }
        });
        presenter.setAdapterListener(listFragmentAdapter);

        FloatingActionButton addPosition = view.findViewById(R.id.fab);
        addPosition.setOnClickListener(v -> {
            FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentPlaceHolder, new ObjectCreationFragment());
            transaction.addToBackStack("ObjectCreation");
            transaction.commit();
        });
    }

    @Override
    public void onResume() {
        presenter.updateAdapter();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.setView(null);
        super.onDestroy();
    }
}
