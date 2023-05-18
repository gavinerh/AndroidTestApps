package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datastorage.dao.UserDao;
import com.example.datastorage.database.AppDatabase;
import com.example.datastorage.entity.User;
import com.example.datastorage.recyclerView.CustomAdapter;
import com.example.datastorage.recyclerView.CustomClickListener;

import java.util.ArrayList;
import java.util.List;

public class ViewAllUsers extends AppCompatActivity implements CustomClickListener {

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

        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"database-name").build();
        userDao = appDatabase.userDao();

        userList = userDao.loadAll();

        if(userList.isEmpty()) {
            emptyMessageTextView = findViewById(R.id.emptyMessage);
            recyclerView = null;
        } else {
            emptyMessageTextView = null;
            recyclerView = findViewById(R.id.recyclerView);
            customAdapter = new CustomAdapter(getApplicationContext(), userList,this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(customAdapter);
        }

    }

    @Override
    public void onClick(int position) {
        User user = userList.get(position);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}