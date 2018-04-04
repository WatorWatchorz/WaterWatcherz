package com.example.water.waterwatcherz;

import java.util.ArrayList;

/**
 * Stores the day and time of a water task, the name of the task (selectable category),
 * and the duration of the task
 * Created by WaterWatcherz on 3/28/2018.
 */

public class WaterTask
{
    //Data

    private String taskName;
    private ArrayList<Integer> date;
    private int time;
    private int duration;

    //Constructors

    /**
     * Constructs a WaterTask object with a given name, date of occurrence(M/D/Y format),
     * time of occurrence(in minutes), and duration time (in minutes)
     * @param taskName the name of the water task
     * @param month the month the water task takes place
     * @param day the day the water task takes place
     * @param year the year the water task takes place
     * @param hour the hour the water task takes place
     * @param minute the minute the water task takes place
     * @param durationHour the integer number of hours the water task takes place
     * @param durationMinute the integer number of minutes extra, after the number of hours, the
     *                       water task takes place
     */
    public WaterTask(String taskName, int month, int day, int year, int hour, int minute,
                     int durationHour, int durationMinute)
    {
        this.taskName = taskName;
        date = new ArrayList<Integer>();
            date.add(month);
            date.add(day);
            date.add(year);
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
        date = new ArrayList<Integer>();
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

    /**
     * Gets the date the water task takes place
     * @return the month, day, and year when the task takes place
     */
    public String getDate()
    {
        return date.get(0) + "/" + date.get (1) + "/" + date.get(2);
    }

    /**
     * Gets the time when the water task takes place
     * @return the time when the task takes place
     */
    public int getTime()
    {
        return time;
    }

    /**
     * Gets the duration of the water task in minutes
     * @return the duration of the task in minutes
     */
    public int getDuration()
    {
        return duration;
    }

}



