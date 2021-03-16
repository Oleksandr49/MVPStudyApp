package com.archstud.architecturestudyapp.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.archstud.architecturestudyapp.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView objectName;
    public Button removeButton;
    public ConstraintLayout constraintLayout;

    public ViewHolder(View itemView) {
        super(itemView);
        objectName = itemView.findViewById(R.id.objectName);
        removeButton = itemView.findViewById(R.id.removeButton);
        constraintLayout = itemView.findViewById(R.id.constraintLayout);
    }
}
