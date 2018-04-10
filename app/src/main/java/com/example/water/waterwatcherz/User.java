package com.example.water.waterwatcherz;

import java.util.ArrayList;

/**
 * Creates a unique User. Contains WaterTask objects and data on a user's household size,
 * zip code, and weekly water goal
 * Created by WaterWatcherz on 3/28/2018.
 */

public class User
{
    //Data

    //Stores String value of the water task
    ArrayList<WaterTask> task;

    //Stores the number of people in the user's household
    private int houseSize;

    //Stores the zip code of the user's house
    private String zip;

    //Stores the numeric value of the weekly goal
    private int weeklyGoal;

    //Stores the name of the user
    private String name;

    //Stores data on whether the water bill is given quarterly, monthly, or yearly
    private String paymentPeriod;

    //Constructor

    //Creates a new user <code>User</code> instance
    //@param userTask a <code>String</code> value containing the water task
    //@param houseNumber a <code>int</code> value containing the number of people in the user's household
    //@param zipCode a <code>int</code> value containing the zip code of the user's house
    //@param weeklyWaterGoal an <code>String</code> value containing the weekly Goal
    public User(ArrayList<WaterTask> userTask, int houseNumber, String zipCode, int weeklyWaterGoal, String userName,
                String paymentPeriod) {
        task = userTask;
        houseSize = houseNumber;
        zip = zipCode;
        weeklyGoal = weeklyWaterGoal;
        name = userName;
        this.paymentPeriod = paymentPeriod;
    }

    public User() {
        task = new ArrayList<>();
        houseSize = 0;
        zip = "null";
        weeklyGoal = 0;
        this.paymentPeriod = null;
    }

    //Methods

    //Accesses this <code>User's</code> water task
    //Returns this <code>User's</code> water task
    public String getTask() {
        String str = "";
        for(int i = 0; i < task.size(); i++)
        {
            str = str + task.get(i).getTaskName();
        }

        return str;
    }

    //Accesses this <code>User's</code> house size
    //Returns this <code>User's</code> house size
    public int getHouseSize() {
        return houseSize;
    }

    //Accesses this <code>User's</code> zip code
    //Returns this <code>User's</code> zip code
    public String getZip() {
        return zip;
    }

    //Accesses this <code>User's</code> weekly goal
    //Returns this <code>User's</code> weekly goal
    public int getWeeklyGoal() {
        return weeklyGoal;
    }


    /**
     * Gets the name of the user
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets data on how often the water bill is given (quarterly, monthly, yearly, or other)
     * @return the payment period
     */
    public String getPaymentPeriod()
    {
        return paymentPeriod;
    }
    @Override
    public String toString() {
        return "Your task is " + task; //+ " and you goal weekly goal is " + weeklyGoal + " for a household size of " + houseSize +
                //" in " + zip + ".";
    }

}