package com.example.water.waterwatcherz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
@Entity
public class Town {

    @PrimaryKey(autoGenerate = true)
    public int id;


    @ColumnInfo(name="townname")
    public String townname;
    @ColumnInfo(name="gallons")
    public int gallons;

    public String getTownname() {
        return townname;
    }

    public void setTownname(String townname) {
        this.townname = townname;
    }

    public int getGallons() {
        return gallons;
    }

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }
    public String toString() {
        return townname+" "+gallons;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
