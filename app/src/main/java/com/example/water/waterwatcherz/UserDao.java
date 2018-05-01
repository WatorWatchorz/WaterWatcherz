package com.example.water.waterwatcherz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by krish on 5/11/2018.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers();
    @Insert
    void insertAll(User... users);

}
