package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.model.CountryModel;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    // recycler view
    RecyclerView recyclerView;
    CountryModel[] dataArr;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get recycler view from xml
        recyclerView = findViewById(R.id.recyclerView);

        dataArr = new CountryModel[]{
                new CountryModel("Singapore", R.drawable.singapore),
                new CountryModel("Brazil", R.drawable.brazil),
                new CountryModel("Italy", R.drawable.italy),
                new CountryModel("Germany", R.drawable.germany),
                new CountryModel("France", R.drawable.france),
                new CountryModel("Turkey", R.drawable.turkey)
        };

        // initialise the adapter
        customAdapter = new CustomAdapter(dataArr, getApplicationContext(), this);
        // handles click events
        customAdapter.setClickListener(this);
        recyclerView.setHasFixedSize(true);
        // inflate items in a linear manner
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
    }


    @Override
    public void onClick(int position) {
        // implement the onClick here, what to do when the item is clicked
        CountryModel countryModel = dataArr[position];
        Toast.makeText(this, "Country name selected: " + countryModel.getTitle(), Toast.LENGTH_SHORT).show();
    }
}