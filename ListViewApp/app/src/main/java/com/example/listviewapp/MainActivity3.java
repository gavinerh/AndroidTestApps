package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listviewapp.adaptor.CustomAdapter;
import com.example.listviewapp.model.ItemContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    ListView listView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String[] arr = intent.getStringArrayExtra("dataSource");
        List<ItemContent> itemContentList = new ArrayList<>();
        for(String name : arr) {
            if (name.equalsIgnoreCase("Malaysia")){
                break;
            }
            ItemContent itemContent = null;
            if(name.equalsIgnoreCase("germany")){
                itemContent = new ItemContent(name + " description",name,R.drawable.germany);
            } else if (name.equalsIgnoreCase("singapore")){
                itemContent = new ItemContent(name + " description",name,R.drawable.singapore);
            } else if (name.equalsIgnoreCase("italy")){
                 itemContent = new ItemContent(name + " description",name,R.drawable.italy);
            } else if (name.equalsIgnoreCase("brazil")) {
                itemContent = new ItemContent(name + " description",name,R.drawable.brazil);
            } else if (name.equalsIgnoreCase("france")) {
                itemContent = new ItemContent(name + " description",name,R.drawable.france);
            } else if (name.equalsIgnoreCase("turkey")){
                itemContent = new ItemContent(name + " description",name,R.drawable.turkey);
            }
            itemContentList.add(itemContent);
        }

        customAdapter = new CustomAdapter(itemContentList,this);

        listView = (ListView) findViewById(R.id.listViewWithImage);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView descView = (TextView) view.findViewById(R.id.countryName);
                Toast.makeText(MainActivity3.this, descView.getText().toString() + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}