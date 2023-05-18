package com.example.datastorage.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.datastorage.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from user")
    List<User> loadAll();

    @Query("Select * from user where first_name like :first AND " + "last_name like :last limit 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
