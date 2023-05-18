package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<CountryModel> {

    private List<CountryModel> courseModelList;

    public CustomAdapter(List<CountryModel> courseModelList, Context context) {
        super(context,0,courseModelList);
        this.courseModelList = courseModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // set the individual view item
        View listItemView = convertView;
        if(listItemView == null) {
            // inflate each item
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item,parent,false);
        }

        CountryModel utilityModel = getItem(position);
        TextView courseTitle = listItemView.findViewById(R.id.courseName);
        courseTitle.setText(utilityModel.getCourseName());

        ImageView imageView = listItemView.findViewById(R.id.gridImageView);
        imageView.setImageResource(utilityModel.getImage());

        return listItemView;
    }
}
