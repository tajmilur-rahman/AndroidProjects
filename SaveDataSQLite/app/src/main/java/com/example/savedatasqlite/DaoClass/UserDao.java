package com.example.savedatasqlite.DaoClass;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.savedatasqlite.DatabaseHelper;
import com.example.savedatasqlite.EntityClass.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

    @Query("SELECT * FROM " + DatabaseHelper.TABLE_NAME)
    LiveData<List<User>> getAll();
}
