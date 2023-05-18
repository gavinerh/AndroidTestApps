package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomClickListener {

    List<CountryModel> countryModelList = new ArrayList<>();
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryModelList.add(new CountryModel("Singapore",R.drawable.singapore));
        countryModelList.add(new CountryModel("France",R.drawable.france));
        countryModelList.add(new CountryModel("Italy",R.drawable.italy));
        countryModelList.add(new CountryModel("Germany",R.drawable.germany));
        countryModelList.add(new CountryModel("Turkey",R.drawable.italy));
        countryModelList.add(new CountryModel("Brazil",R.drawable.brazil));
//        countryModelList.add(new CountryModel("Singapore",R.drawable.singapore));
//        countryModelList.add(new CountryModel("France",R.drawable.france));
//        countryModelList.add(new CountryModel("Italy",R.drawable.italy));
//        countryModelList.add(new CountryModel("Germany",R.drawable.germany));
//        countryModelList.add(new CountryModel("Turkey",R.drawable.italy));
//        countryModelList.add(new CountryModel("Brazil",R.drawable.brazil));

        recyclerView = findViewById(R.id.recyclerView);
        customAdapter = new CustomAdapter(countryModelList,getApplicationContext(),this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void onItemClicked(int position) {
        CountryModel model = countryModelList.get(position);
        Toast.makeText(this, "Clicked on: " + model.getCountryName(), Toast.LENGTH_SHORT).show();
    }
}