package com.example.water.waterwatcherz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

    @Dao
    public interface TownDao {
        @Query("DELETE FROM town")
        public void deleteTables();
        @Query("SELECT * FROM town")
        List<Town> getallTowns();
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        public void insertTown(Town...towns);
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        public void insertAllTowns(List<Town> towns);
        @Query("SELECT * FROM Town where townname LIKE :name")
        public int getidfromName(String name);
    }


