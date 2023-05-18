package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datastorage.dao.UserDao;
import com.example.datastorage.database.AppDatabase;
import com.example.datastorage.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button selectAllButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addUserBtn);
        selectAllButton = findViewById(R.id.getAllUsersBtn);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddUser.class);
                startActivity(intent);
            }
        });

        selectAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewAllUsers.class);
                startActivity(intent);
            }
        });
    }
}