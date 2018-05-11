package com.example.water.waterwatcherz;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by krish
 */
@Database(entities = {User.class,WaterTask.class,Town.class}, version=6,  exportSchema = false)
    public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract WaterTaskDao waterTaskDao();
    public abstract TownDao townDao();
}

