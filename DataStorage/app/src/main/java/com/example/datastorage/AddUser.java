package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datastorage.dao.UserDao;
import com.example.datastorage.database.AppDatabase;
import com.example.datastorage.entity.User;

import java.util.UUID;

public class AddUser extends AppCompatActivity {

    AppDatabase appDatabase;
    UserDao userDao;

    EditText firstNameEdit;
    EditText lastNameEdit;
    Button saveBtn;
    Button cancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"database-name").build();
        userDao = appDatabase.userDao();

        firstNameEdit = findViewById(R.id.firstName);
        lastNameEdit = findViewById(R.id.lastName);

        saveBtn = findViewById(R.id.saveBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        initialiseBtn();
    }

    private void initialiseBtn() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNameText = firstNameEdit.getText().toString();
                String lastNameText = lastNameEdit.getText().toString();
                if(!firstNameText.isEmpty() || !lastNameText.isEmpty()){
                    String uuid = UUID.randomUUID().toString();
                    User user = new User();
                    user.key = uuid;
                    user.firstName = firstNameText;
                    user.lastName = lastNameText;
                    userDao.insertAll(user);

                    create a separate thread for database operations
                }
                Toast.makeText(AddUser.this, "User saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}