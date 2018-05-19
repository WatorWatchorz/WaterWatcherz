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
        //(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id",childColumns = "userid"))
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
//    private ArrayList<Integer> date;
    @ColumnInfo(name = "month")
    private int month;

    @ColumnInfo(name = "day")
    private int day;
    @ColumnInfo(name = "year")
    private int year;

    @ColumnInfo(name = "time")
    private int time;

    @ColumnInfo(name = "week")
    private int week;


    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;

    //Constructors

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Constructs a WaterTask object with a given name, date of occurrence(M/D/Y format),
     * time of occurrence(in minutes), and duration time (in minutes)
     * @param taskName the name of the water task
     * @param month the month the water task takes place
     * @param week the week the water task takes place
     * @param day the day the water task takes place
     * @param year the year the water task takes place
     * @param hour the hour the water task takes place
     * @param minute the minute the water task takes place
     * @param durationHour the integer number of hours the water task takes place
     * @param durationMinute the integer number of minutes extra, after the number of hours, the
     *                       water task takes place
     */
    public WaterTask(String taskName, int month, int week, int day, int year, int hour, int minute,
                     int durationHour, int durationMinute)
    {
        this.taskName = taskName;
   /*     date = new ArrayList<>();
            date.add(month);
            date.add(day);
            date.add(year);*/
        time = hour * 60 + minute;
        duration = durationHour * 60 + durationMinute;
    }

    /**
     * Constructs a WaterTask object with the name "Empty", a null date of occurrence,
     * a time of occurrence of 0 minutes, and a duration of 0 minutes
     */
    public WaterTask()
    {
        this.taskName = "Empty";
       /* date = new ArrayList<>();
            date.add(0);
            date.add(0);
            date.add(0);*/
        time = 0;
        duration = 0;
    }

    //Methods

    /**
     * Gets the name of the water task
     * @return the name of the task
     */
    public String getTaskName()
    {
        return taskName;
    }


    public int getTime()
    {
        return time;
    }

    /**
     * Gets the duration of the water task in minutes
     * @return the duration of the task in minutes
     */
    public int getDuration() {
        return duration;
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
                return 16590;
            case "Laundry":
                return 25;
            case "Shower":
                return duration*3;
            case "Washing Dishes":
                return 6;
            case "Watering Lawn":
                return duration*2;
            default:
                return 0;
        }
    }

    public double getAmt_ActualGallons() {
        int total = 0;
        switch (taskName)
        {
            case "Bath":
                return total + 36;
            case "Brushing Teeth":
                return duration;
            case "Filling Pool":
                return total + 16590;
            case "Laundry":
                return total + 25;
            case "Shower":
                return total + duration*3;
            case "Washing Dishes":
                return total + 6;
            case "Watering Lawn":
                return total + duration * 2;
            default:
                return 0;
        }
    }

    public String toString() {
        return "Month: " + Integer.toString(month) + " Week: " + Integer.toString(week) + "\t" + "\t" + "\t" + taskName;
    }
}