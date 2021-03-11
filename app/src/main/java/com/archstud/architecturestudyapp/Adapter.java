package com.archstud.architecturestudyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.fragments.ListPresenter;
import com.archstud.architecturestudyapp.fragments.Presenter;
import com.archstud.architecturestudyapp.repository.DataObject;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private final Presenter presenter;
    private final List<DataObject> dataObjects = new ArrayList<>();

    public Adapter(Presenter presenter){
        this.presenter = presenter;
    }

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
       // holder.objectName.setOnClickListener(v -> ((ListPresenter)presenter).showDetails(holder.objectName.toString()));

        holder.removeButton.setOnClickListener(v -> {
            ((ListPresenter)presenter).showConfirmationDialog(holder.getAdapterPosition());
        });
    }

    public void addItem(DataObject dataObject){
        this.dataObjects.add(dataObject);
        notifyItemInserted(dataObjects.size()-1);
    }

    public void removePosition(int position){
        DataObject objectToRemove = dataObjects.get(position);
        dataObjects.remove(position);
        notifyItemRemoved(position);
        ((ListPresenter)presenter).removePositionFromDatabase(objectToRemove.getName());
    }

    @Override
    public int getItemCount () {
        return dataObjects.size();
    }

    public void initListItems(List<DataObject> dataObjects){
        this.dataObjects.addAll(dataObjects);
        notifyItemRangeInserted(0, dataObjects.size());
    }

}
