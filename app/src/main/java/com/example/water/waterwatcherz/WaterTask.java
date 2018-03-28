package com.example.water.waterwatcherz;

import java.util.Calendar;

/**
 * Stores the day and time of a water task, the name of the task (selectable category),
 * and the duration of the task
 * Created by eesha on 3/28/2018.
 */

public class WaterTask
{
    //Data

    //Constructor

        //Constructs Calendar object initialized with date and time of the user's program's locale
       Calendar taskCalendar = Calendar.getInstance();

    //Methods

    /**
     *Returns the date and time of the water task
     * @return the Calendar object that stores the date and time of the intended water task
     */
    public Calendar getTaskCalendar()
    {
        return taskCalendar;
    }



}



