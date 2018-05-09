package com.example.water.waterwatcherz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by krish on 5/11/2018.
 */
@Dao
public interface UserDao {
    @Query("DELETE FROM user")
    public void deleteTables();
    @Query("SELECT * FROM user")
    List<User> getAllUsers();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User...users);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertallUsers(List<User> users);
    //@Query("SELECT * FROM watertask WHERE userid=:id")
    //public void getUserWaterTasks(int id);
}
