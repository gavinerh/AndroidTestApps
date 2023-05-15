package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // create list view
    ListView listView;

    // data source
    String[] arrData = new String[]{"Germany","France","Italy","Turkey","Brazil","Singapore","Malaysia","Brunei",
    "Dubai","USA","United Kingdom","Scotland","Indonesia","Australia","South Africa","Argentina","Mexico","Sao Paolo","Portugal"};

    Button button;

    Button buttonToView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // create adapter with default simple list item
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                arrData);

        button = findViewById(R.id.toCustomListItem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("dataSource",arrData);
                startActivity(intent);
            }
        });

        // create adapter with custom view


        // set adapter to list view
        listView.setAdapter(adapter);

        buttonToView3 = findViewById(R.id.view3Btn);
        buttonToView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                intent.putExtra("dataSource",arrData);
                startActivity(intent);
            }
        });
    }
}