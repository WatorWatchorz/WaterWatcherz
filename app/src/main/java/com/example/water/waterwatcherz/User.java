package com.example.water.waterwatcherz;

/**
 * Creates a unique User. Contains WaterTask objects and data on a user's household size,
 * zip code, and weekly water goal
 * Created by WaterWatcherz on 3/28/2018.
 */

public class User
{
    //Data

    //Stores String value of the water task
    private String task;

    //Stores the number of people in the user's household
    private int houseSize;

    //Stores the zip code of the user's house
    private int zip;

    //Stores the String value of the weekly Goal
    private String weeklyGoal;

    //Constructor

    //Creates a new user <code>User</code> instance
    //@param userTask a <code>String</code> value containing the water task
    //@param houseNumber a <code>int</code> value containing the number of people in the user's household
    //@param zipCode a <code>int</code> value containing the zip code of the user's house
    //@param weeklyWaterGoal an <code>String</code> value containing the weekly Goal
    public User(String userTask, int houseNumber, int zipCode, String weeklyWaterGoal) {
        task = userTask;
        houseSize = houseNumber;
        zip = zipCode;
        weeklyGoal = weeklyWaterGoal;
    }

    public User() {
        task = null;
        houseSize = 0;
        zip = 0;
        weeklyGoal = null;
    }

    //Methods

    //Accesses this <code>User's</code> water task
    //Returns this <code>User's</code> water task
    public String getTask() {
        return task;
    }

    //Accesses this <code>User's</code> house size
    //Returns this <code>User's</code> house size
    public int getHouseSize() {
        return houseSize;
    }

    //Accesses this <code>User's</code> zip code
    //Returns this <code>User's</code> zip code
    public int getZip() {
        return zip;
    }

    //Accesses this <code>User's</code> weekly goal
    //Returns this <code>User's</code> weekly goal
    public String getWeeklyGoal() {
        return weeklyGoal;
    }

}
