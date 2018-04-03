package com.example.water.waterwatcherz;

import java.util.Calendar;

/**
 * Stores the day and time of a water task, the name of the task (selectable category),
 * and the duration of the task
 * Created by WaterWatcherz on 3/28/2018.
 */

public class WaterTask
{
    //Data
    private String taskName;
    private int date;
    private int time;
    private int duration;

    //Constructor

    public WaterTask(String taskName, int month, int day, int year, int hour, int minute,
                     int durationHour, int durationMinute)
    {
        this.taskName = taskName;
        time = hour * 60 + minute;
        duration = durationHour * 60 + durationMinute;

    }

    public WaterTask()
    {

    }

    //Methods

    /**
     * Gets the name of the water task
     * @return the name of the water task
     */
    public String getTaskName()
    {
        return taskName;
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



