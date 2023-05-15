package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.model.CountryModel;
import com.example.recyclerview.model.CustomViewHolder;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    // data source
    private CountryModel[] listData;
    Context context;

    // handling click events
    private ItemClickListener clickListener;

    public CustomAdapter(CountryModel[] listData, Context context, ItemClickListener itemClickListener) {
        this.listData = listData;
        this.context = context;
        this.clickListener = itemClickListener;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creates a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recycler_view_item,parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(listItem);
        viewHolder.setItemClickListener(clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        // get and bind the new data
        // layout is inflated
        final CountryModel vaccineData = listData[position];
        holder.textView.setText(listData[position].getTitle());
        holder.imageView.setImageResource(listData[position].getImage());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickListener.onClick(listData[position]);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }


}
