package com.example.water.waterwatcherz;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by krish on 5/11/2018.
 */
@Database(entities = {User.class}, version=1,  exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

