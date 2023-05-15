package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {

    ListView customListView;

    String[] arrData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        customListView = findViewById(R.id.customListView);
        Intent intent = getIntent();
        arrData = intent.getStringArrayExtra("dataSource");

        // note that to set own custom view item, need to pass in the textview id as well
        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.custom_list_view_item, R.id.customTextView,arrData);
        customListView.setAdapter(adapter);
    }
}