package com.example.water.waterwatcherz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WaterTaskDao {
    @Query("SELECT * FROM WaterTask")
    List<WaterTask> getAllWaterTasks();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWaterTask(WaterTask waterTask);
    @Delete
    void deleteWaterTasks(WaterTask... waterTasks);
}
