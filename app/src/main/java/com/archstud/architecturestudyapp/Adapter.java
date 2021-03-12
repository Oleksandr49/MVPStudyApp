package com.archstud.architecturestudyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.repository.DataObject;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> implements RecyclerViewAdapter {

    private final List<DataObject> dataObjects = new ArrayList<>();
    private PresenterListener presenterListener;

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
        holder.removeButton.setOnClickListener(v -> presenterListener.showRemovalConfirmationDialog(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount () {
        return dataObjects.size();
    }

    @Override
    public void addListOfItemsToAdapter(List<DataObject> items) {
        this.dataObjects.addAll(items);
        notifyItemRangeInserted(0, dataObjects.size());
    }

    @Override
    public void addItemToAdapter(DataObject dataObject) {
        this.dataObjects.add(dataObject);
        notifyItemInserted(dataObjects.size()-1);
    }

    @Override
    public void removeItemFromAdapter(int position) {
        presenterListener.deleteObjectFromDatabase(dataObjects.get(position).getId());
        dataObjects.remove(position);
        notifyItemRemoved(position);
    }

    public void setPresenterListener(PresenterListener presenterListener) {
        this.presenterListener = presenterListener;
    }
}
