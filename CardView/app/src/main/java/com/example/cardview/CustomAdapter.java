package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<CountryModel> countryModelList;
    Context context;

    private CustomClickListener clickListener;

    public CustomAdapter(List<CountryModel> countryModelList, Context context, CustomClickListener clickListener) {
        this.countryModelList = countryModelList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create inflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // inflate card item
        View cardItem = inflater.inflate(R.layout.card_item,parent,false);
        // create the view holder and attach the card item to holder
        CustomViewHolder viewHolder = new CustomViewHolder(cardItem);
        viewHolder.setItemClickListener(clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        CountryModel countryModel = countryModelList.get(position);
        holder.textView.setText(countryModel.getCountryName());
        holder.imageView.setImageResource(countryModel.getCountryImage());
    }

    @Override
    public int getItemCount() {
        return countryModelList.size();
    }
}
