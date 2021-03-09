package com.archstud.architecturestudyapp;

import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView objectName;
    public TextView objectDetails;
    public ConstraintLayout constraintLayout;

    public ViewHolder(View itemView) {
        super(itemView);
        objectName = itemView.findViewById(R.id.objectName);
        objectDetails = itemView.findViewById(R.id.objectDetails);
        constraintLayout = itemView.findViewById(R.id.constraintLayout);
    }
}
