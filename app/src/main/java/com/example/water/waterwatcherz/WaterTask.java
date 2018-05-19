package com.example.water.waterwatcherz;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.migration.Migration;
import android.support.v4.app.ServiceCompat;

import java.util.ArrayList;


/**
 * Stores the day and time of a water task, the name of the task (selectable category),
 * and the duration of the task
 * Created by WaterWatcherz on 3/28/2018.
 */
@Entity

public class WaterTask
{

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    //Data

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userid")
    int userid;

    @ColumnInfo(name = "taskName")
    private String taskName;

    @ColumnInfo(name = "month")
    private int month;

    @ColumnInfo(name = "week")
    private int week;

    private int duration;

    //Constructors

    /**
     * Constructs a WaterTask object with a given name, date of occurrence(M/D/Y format),
     * time of occurrence(in minutes), and duration time (in minutes)
     * @param taskName the name of the water task
     * @param month the month the water task takes place
     * @param week the week the water task takes place
     * @param durationHour the integer number of hours the water task takes place
     * @param durationMinute the integer number of minutes extra, after the number of hours, the
     *                       water task takes place
     */
    public WaterTask(String taskName, int month, int week,
                     int durationHour, int durationMinute)
    {
        this.taskName = taskName;
        duration = durationHour * 60 + durationMinute;
    }

    /**
     * Constructs a WaterTask object with the name "Empty", a null date of occurrence,
     * a time of occurrence of 0 minutes, and a duration of 0 minutes
     */
    public WaterTask()
    {
        this.taskName = "Empty";
        duration = 0;
    }

    /**
     * gets the month of the water-related task
     * @return the month of the water-related task
     */
    public int getMonth() {
        return month;
    }

    /**
     * sets the month of the water-related task
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * gets the week in the month the water-related task takes place
     * @return week in the month the water-related task takes place
     */
    public int getWeek() {
        return week;
    }

    /**
     * sets the week in the month the water-related task takes place
     * @param week
     */
    public void setWeek(int week) {
        this.week = week;
    }

    /**
     * Gets the name of the water task
     * @return the name of the task
     */
    public String getTaskName()
    {
        return taskName;
    }

    /**
     * Gets the duration of the water task in minutes
     * @return the duration of the task in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * sets the name of the water-related task
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * sets the duration of the water-related task
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the amount of the water in gallons
     * @return the amount of water for each task in gallons
     */
    public double getAmt_gallons() {
        switch (taskName)
        {
            case "Bath":
                return 36;
            case "Brushing Teeth":
                return duration;
            case "Filling Pool":
                return 17*duration;
            case "Laundry":
                return 2*duration;
            case "Shower":
                return duration*3;
            case "Washing Dishes":
                return duration*1.5;
            case "Watering Lawn":
                return duration*2;
            default:
                return 0;
        }
    }

    /**
     * gets a String statement that tells the user the month, week, and the task
     * @return "Month: " + Integer.toString(month) + " Week: " + Integer.toString(week) + "\t" + "\t" + "\t" + taskName
     */
    public String toString() {
        return "Month: " + Integer.toString(month) + " Week: " + Integer.toString(week) + "\t" + "\t" + "\t" + taskName;
    }
}