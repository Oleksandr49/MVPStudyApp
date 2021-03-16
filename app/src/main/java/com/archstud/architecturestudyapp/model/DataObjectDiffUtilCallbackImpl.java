package com.archstud.architecturestudyapp.model;

import androidx.recyclerview.widget.DiffUtil;

import com.archstud.architecturestudyapp.model.domainModels.DataObject;

import java.util.List;

public class DataObjectDiffUtilCallbackImpl extends DiffUtil.Callback {

    private final List<DataObject> oldList;
    private final List<DataObject> newList;

    public DataObjectDiffUtilCallbackImpl(List<DataObject> oldList, List<DataObject> newList){
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        DataObject oldItem = oldList.get(oldItemPosition);
        DataObject newItem = newList.get(newItemPosition);
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        DataObject oldItem = oldList.get(oldItemPosition);
        DataObject newItem = newList.get(newItemPosition);
        return (oldItem.getName().equals(newItem.getName()) && oldItem.getDetails().equals(newItem.getDetails()));
    }
}
