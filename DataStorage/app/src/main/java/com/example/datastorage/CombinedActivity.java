package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datastorage.dao.UserDao;
import com.example.datastorage.database.AppDatabase;
import com.example.datastorage.entity.User;
import com.example.datastorage.recyclerView.CustomAdapter;
import com.example.datastorage.recyclerView.CustomClickListener;
import com.example.datastorage.recyclerView.DeleteListener;

import java.util.List;

public class CombinedActivity extends AppCompatActivity implements CustomClickListener, DeleteListener {

    AppDatabase appDatabase;
    UserDao userDao;
    RecyclerView recyclerView;
    TextView textView;
    List<User> userList;
    CustomAdapter customAdapter;
    Button combinedOpenDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        recyclerView = findViewById(R.id.combinedRecyclerView);
        textView = findViewById(R.id.combinedViewTextView);
        combinedOpenDialogBtn = findViewById(R.id.combinedOpenDialog);
        combinedOpenDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });

        getUsersFromDatabase();

    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(CombinedActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.gray);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.add_user_dialog);

        // initialising the views of the dialog
        final Button addNewUserBtn = dialog.findViewById(R.id.combinedAddNewUserBtn);
        addNewUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddUser.class);
                startActivity(intent);
            }
        });
        dialog.show();
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
        if(textView == null) {
            textView = findViewById(R.id.emptyMessage);
        }
        if(!userList.isEmpty()) {
            textView.setVisibility(View.GONE);
            if(customAdapter == null) {
                customAdapter = new CustomAdapter(getApplicationContext(), userList, CombinedActivity.this, CombinedActivity.this);
            } else {
                customAdapter.setUserList(userList);
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(customAdapter);
        } else {
            textView.setText("List is empty");
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
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