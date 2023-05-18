package com.example.datastorage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.datastorage.dao.UserDao;
import com.example.datastorage.entity.User;

@Database(entities = {User.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
