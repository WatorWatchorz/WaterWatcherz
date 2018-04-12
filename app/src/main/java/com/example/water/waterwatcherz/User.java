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
    private ArrayList<WaterTask> task;

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

    //Stores the number of times the user brushes their teeth in a day
    private int brushTeethNum;

    //Stores the amount of time the user brushes their teeth for
    private int brushTeethTime;

    //Stores data on whether the user generally showers or takes a bath
    private String wash;

    //Stores the number of times a day the user showers or takes a bath
    private int numWash;

    //Constructor

    /**
     * Constructs a new User object
     * @param userTask an ArrayList containing the user's WaterTask objects
     * @param houseNumber an integer value containing the number of people in the user's household
     * @param zipCode an integer value containing the zip code of the user's house
     * @param weeklyWaterGoal a String containing the user's weekly goal
     * @param userName a String containing the name of the user
     * @param paymentPeriod a string containing data on how often the water bill is delivered
     * @param brushTeethNum the number of times the user brushes their teeth in a day
     * @param brushTeethTime the amount of time the user brushes their teeth for
     * @param wash a String that stores whether the user generally showers or takes a bath
     * @param numWash the number of times the user generally shower or takes a bath in a day
     */
    public User(ArrayList<WaterTask> userTask, int houseNumber, String zipCode, int weeklyWaterGoal, String userName,
                String paymentPeriod, int brushTeethNum, int brushTeethTime, String wash, int numWash) {
        task = userTask;
        houseSize = houseNumber;
        zip = zipCode;
        weeklyGoal = weeklyWaterGoal;
        name = userName;
        this.paymentPeriod = paymentPeriod;
        this.brushTeethNum = brushTeethTime;
        this.brushTeethTime = brushTeethTime;
        this.wash = wash;
        this.numWash = numWash;
    }

    /**
     * Constructs an empty User object
     */
    public User() {
        task = new ArrayList<>();
        houseSize = 0;
        zip = "null";
        weeklyGoal = 0;
        name = "null";
        paymentPeriod = null;
        brushTeethNum = 0;
        brushTeethTime = 0;
        wash = "null";
        numWash = 0;
    }

    //Methods

    /**
     * Accesses this User's water task
     * @return this User's water task
     */
    public String getTask() {
        String str = "";
        for(int i = 0; i < task.size(); i++)
        {str = str + task.get(i).getTaskName();}
        return str;
    }

    /**
     * Accesses this User's house size
     * @return this User's house size
     */
    public int getHouseSize() {
        return houseSize;
    }

    /**
     * Accesses this User's zip code
     * @return this User's zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Accesses this User's weekly goal
     * @return this User's weekly goal
     */
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



    /**
     * Accepts values for the number of times a user brushes their teeth and for how long
     * @param brushTeethNum the number of times a user brushes their teeth in a day
     * @param brushTeethTime the amount of time the user brushes their teeth for each time, in minutes
     */
//    public void setBrushTeeth(int brushTeethNum, int brushTeethTime)
//    {
//        this.brushTeethNum = brushTeethNum;
//        this.brushTeethTime = brushTeethTime;
//    }



    /**
     * Gets the number of times a user brushes their teeth
     * @return the number of times a user brushes their teeth
     */
    public int getBrushTeethNum(){return brushTeethNum;}

    /**
     * Gets the amount of time a user brushes their teeth for
     * @return the amount of time a user brushes their teeth for, in minutes
     */
    public int getBrushTeethTime(){return brushTeethTime;}

    /**
     * Gets data on whether the user generally showers or takes a bath
     * @return a String; either "Shower" or "Bath"
     */
    public String getWash (){return wash;}

    /**
     * Gets the number of times a day the user showers or takes a bath
     * @return the number of times a day the user showers or takes a bath
     */
    public int getnumWash(){return numWash;}

    @Override
    public String toString() {
        return "Your task is " + task; //+ " and you goal weekly goal is " + weeklyGoal + " for a household size of " + houseSize +
                //" in " + zip + ".";
    }

}