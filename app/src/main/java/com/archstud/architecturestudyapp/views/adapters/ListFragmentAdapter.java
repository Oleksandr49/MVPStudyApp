package com.archstud.architecturestudyapp.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.model.DataObjectDiffUtilCallbackImpl;
import com.archstud.architecturestudyapp.model.domainModels.DataObject;
import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.presenters.ListFragmentPresenterListener;
import com.archstud.architecturestudyapp.views.interfaces.AdapterListener;
import com.archstud.architecturestudyapp.views.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ListFragmentAdapter extends RecyclerView.Adapter<ViewHolder> implements AdapterListener<DataObject> {

    private List<DataObject> dataObjects = new ArrayList<>();
    private ListFragmentPresenterListener<DataObject> presenterListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.objectName.setText(dataObjects.get(position).getName());
        holder.objectName.setOnClickListener(v -> presenterListener.showDetails());
        holder.removeButton.setOnClickListener(v ->
                presenterListener.showRemovalConfirmationDialog(() ->
                        presenterListener.deleteObjectFromDatabase(dataObjects.get(holder.getAdapterPosition()).getId())));
    }

    @Override
    public int getItemCount () {
        return dataObjects.size();
    }


    @Override
    public void setPresenterListener(ListFragmentPresenterListener<DataObject> presenterListener) {
        this.presenterListener = presenterListener;
    }

    @Override
    public void updateAdapter(List<DataObject> updatedData) {
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DataObjectDiffUtilCallbackImpl(dataObjects, updatedData));
        setDataObjects(updatedData);
        result.dispatchUpdatesTo(this);
    }

    private void setDataObjects(List<DataObject> dataObjects) {
        this.dataObjects = dataObjects;
    }
}
