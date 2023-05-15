package com.example.listviewapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewapp.R;
import com.example.listviewapp.model.ItemContent;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<ItemContent> {
    private List<ItemContent> dataArray;
    Context context;

    public CustomAdapter(List<ItemContent> data, Context context) {
        super(context, 0, data);
        this.dataArray = data;
        this.context = context;
    }

    // View lookup cache
//    private static class ViewHolder {
//        TextView countryName;
//        TextView description;
//        ImageView flagImage;
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            // if the item content is not used, then create the view
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_with_image,parent,false);
        }
        // get the obj given the position it is in
        ItemContent itemContent = dataArray.get(position);

        // populate the image view and text data to widget
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        imageView.setImageResource(itemContent.getImage());
        TextView countryName = (TextView) convertView.findViewById(R.id.countryName);
        countryName.setText(itemContent.getCountryName());
        TextView desc = (TextView) convertView.findViewById(R.id.cupDescription);
        desc.setText(itemContent.getDescription());

        return convertView;
    }

    //    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        // get the data item for this position
//        ItemContent item = getItem(position);
//
//        // check if an existing view is being reused, otherwise need to inflate the view
//        ViewHolder viewHolder;
//
//        final View result;
//
//        if(convertView == null) {
//            viewHolder = new ViewHolder();
//
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//
//            convertView = inflater.inflate(R.layout.list_item_with_image
//            ,parent,false);
//
//            viewHolder.countryName = ( TextView) convertView.findViewById(R.id.countryName);
//            viewHolder.description = (TextView) convertView.findViewById(R.id.cupDescription);
//            viewHolder.flagImage = (ImageView) convertView.findViewById(R.id.imageView);
//
//            result = convertView;
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//            result = convertView;
//        }
//
//        // get the data from model class
//        viewHolder.countryName.setText(item.getCountryName());
//        viewHolder.description.setText(item.getDescription());
//        viewHolder.flagImage.setImageResource(item.getImage());
//
//        return convertView;
//    }
}
