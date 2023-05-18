package com.example.cardview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageView;
    public TextView textView;
    private CustomClickListener clickListener;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.countryImage);
        this.textView = itemView.findViewById(R.id.countryName);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(CustomClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        if(clickListener != null) {
            clickListener.onItemClicked(getAdapterPosition());
        }
    }
}
