package com.archstud.architecturestudyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.repository.DataObject;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<DataObject> dataObjects = new ArrayList<>();

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
        holder.objectDetails.setText(dataObjects.get(position).getDetails());
    }

    @Override
    public int getItemCount () {
        return dataObjects.size();
    }


    public void addItemToAdapter(DataObject dataObject){
        this.dataObjects.add(dataObject);
        notifyItemInserted(dataObjects.size() - 1);
    }
}
