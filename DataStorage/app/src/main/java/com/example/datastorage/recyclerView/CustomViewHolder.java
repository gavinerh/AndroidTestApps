package com.example.datastorage.recyclerView;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datastorage.R;

public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public EditText editTextFirstName;
    public EditText editTextLastName;
    private CustomClickListener clickListener;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.editTextFirstName = itemView.findViewById(R.id.viewFirstName);
        this.editTextLastName = itemView.findViewById(R.id.viewLastName);
        itemView.setOnClickListener(this);
    }

    public void setCustomClickListener(CustomClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        if(clickListener != null) {
            clickListener.onClick(getAdapterPosition());
        }
    }
}
