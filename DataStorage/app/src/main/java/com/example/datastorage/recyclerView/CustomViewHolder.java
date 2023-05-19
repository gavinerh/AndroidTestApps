package com.example.datastorage.recyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datastorage.R;
import com.example.datastorage.database.AppDatabase;

public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public EditText editTextFirstName;
    public EditText editTextLastName;
    public Button deleteBtn;
    private CustomClickListener clickListener;
    private DeleteListener deleteListener;
    private AppDatabase appDatabase;

    public CustomViewHolder(@NonNull View itemView, DeleteListener deleteListener) {
        super(itemView);
        this.editTextFirstName = itemView.findViewById(R.id.viewFirstName);
        this.editTextLastName = itemView.findViewById(R.id.viewLastName);
        this.deleteBtn = itemView.findViewById(R.id.deleteBtn);
        this.deleteListener = deleteListener;
        initialiseDeleteBtn();
        itemView.setOnClickListener(this);
    }

    private void initialiseDeleteBtn() {
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteListener.deleteItem(getAdapterPosition());
            }
        });
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
