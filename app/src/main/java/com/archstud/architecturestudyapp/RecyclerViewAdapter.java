package com.archstud.architecturestudyapp;

import com.archstud.architecturestudyapp.repository.DataObject;

import java.util.List;

public interface RecyclerViewAdapter {

    void addListOfItemsToAdapter(List<DataObject> items);
    void addItemToAdapter(DataObject dataObject);
    void removeItemFromAdapter(int position);
}
