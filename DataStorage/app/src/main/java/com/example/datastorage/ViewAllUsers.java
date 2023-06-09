package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datastorage.dao.UserDao;
import com.example.datastorage.database.AppDatabase;
import com.example.datastorage.entity.User;
import com.example.datastorage.recyclerView.CustomAdapter;
import com.example.datastorage.recyclerView.CustomClickListener;
import com.example.datastorage.recyclerView.DeleteListener;

import java.util.ArrayList;
import java.util.List;

public class ViewAllUsers extends AppCompatActivity implements CustomClickListener, DeleteListener {

    List<User> userList;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    UserDao userDao;
    TextView emptyMessageTextView;

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        getUsersFromDatabase();


    }

    private void getUsersFromDatabase() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
                userDao = appDatabase.userDao();
                userList = userDao.loadAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        defaultSetup();
                    }
                });
            }
        }).start();
    }

    private void defaultSetup() {
        if(recyclerView == null) {
            recyclerView = findViewById(R.id.recyclerView);
        }
        if(emptyMessageTextView == null) {
            emptyMessageTextView = findViewById(R.id.emptyMessage);
        }
        if(!userList.isEmpty()) {
            emptyMessageTextView.setVisibility(View.GONE);
            if(customAdapter == null) {
                customAdapter = new CustomAdapter(getApplicationContext(), userList, ViewAllUsers.this, ViewAllUsers.this);
            } else {
                customAdapter.setUserList(userList);
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(customAdapter);
        } else {
            emptyMessageTextView = findViewById(R.id.emptyMessage);
            emptyMessageTextView.setText("List is empty");
            recyclerView.setVisibility(View.GONE);
            emptyMessageTextView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(int position) {
        User user = userList.get(position);
        Toast.makeText(this, "Clicked on: " + user.firstName + " " + user.lastName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteItem(int position) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = userList.get(position);
                userDao.delete(user);
                userList = userDao.loadAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        defaultSetup();
                    }
                });
            }
        }).start();
    }
}