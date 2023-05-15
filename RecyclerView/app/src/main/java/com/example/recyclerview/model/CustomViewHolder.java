package com.example.recyclerview.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.ItemClickListener;
import com.example.recyclerview.R;

public class CustomViewHolder extends RecyclerView.ViewHolder  {

        public ImageView imageView;
        public TextView textView;
        private ItemClickListener itemClickListener;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
//            itemView.setOnClickListener(this);
        }


//    @Override
//    public void onClick(View v) {
//        if(itemClickListener != null) {
//            View view = v.getRootView();
//            itemClickListener.onClick(view.get);
//        }
//    }
}