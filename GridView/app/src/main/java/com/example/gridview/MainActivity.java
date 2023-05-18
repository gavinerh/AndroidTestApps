package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        ArrayList<CountryModel> courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CountryModel(R.drawable.brazil,"Brazil") );
        courseModelArrayList.add(new CountryModel(R.drawable.france,"France"));
        courseModelArrayList.add(new CountryModel(R.drawable.germany,"Germany"));
        courseModelArrayList.add(new CountryModel(R.drawable.italy,"Italy"));
        courseModelArrayList.add(new CountryModel(R.drawable.singapore,"Singapore"));
        courseModelArrayList.add(new CountryModel(R.drawable.turkey,"Turkey"));

        CustomAdapter customAdapter = new CustomAdapter(courseModelArrayList,getApplicationContext());
        gridView.setAdapter(customAdapter);
    }
}