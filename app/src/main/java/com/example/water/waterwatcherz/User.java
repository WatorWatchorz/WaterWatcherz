package com.example.water.waterwatcherz;

import java.util.ArrayList;

/**
 * Creates a unique User. Contains WaterTask objects and data on a user's household size,
 * zip code, and weekly water goal
 * Created by WaterWatcherz on 3/28/2018.
 */

public class User {
    //Data

    //Stores a list of water task objects
    private ArrayList<WaterTask> tasks;
    //Stores the number of people in the user's household
    private int houseSize;
    //Stores the zip code of the user's house
    private String zip;
    //Stores the numeric value of the weekly goal in gallons
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
     *
     * @param userTask        an ArrayList containing the user's WaterTask objects
     * @param houseNumber     an integer value containing the number of people in the user's household
     * @param zipCode         a String value containing the zip code of the user's house
     * @param weeklyWaterGoal a String containing the user's weekly goal
     * @param userName        a String containing the name of the user
     * @param paymentPeriod   a string containing data on how often the water bill is delivered
     * @param brushTeethNum   the number of times the user brushes their teeth in a day
     * @param brushTeethTime  the amount of time the user brushes their teeth for
     * @param wash            a String that stores whether the user generally showers or takes a bath
     * @param numWash         the number of times the user generally shower or takes a bath in a day
     */
    public User(ArrayList<WaterTask> userTask, int houseNumber, String zipCode, int weeklyWaterGoal, String userName,
                String paymentPeriod, int brushTeethNum, int brushTeethTime, String wash, int numWash) {
        tasks = userTask;
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
        tasks = new ArrayList<>();
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
     * Sets the household size of the user
     *
     * @param houseSize_in the user's house size
     */
    public void setHouseSize(int houseSize_in) {
        houseSize = houseSize_in;
    }

    /**
     * Accesses this user's house size
     *
     * @return this user's house size
     */
    public int getHouseSize() {
        return houseSize;
    }

    /**
     * Gets a string containing all the user's water tasks
     *
     * @return the user's water tasks
     */
    public String getTasks() {
        String str = "";
        for (int i = 0; i < tasks.size(); i++) {
            str = str + (tasks.get(i)).getTaskName();
        }
        return str;
    }

    /**
     * Adds a water task to the user's list of water tasks
     *
     * @param userTask a new water task
     */
    public void setUserTask(WaterTask userTask) {
        tasks.add(userTask);
    }

    /**
     * Sets the zipcode of a user
     *
     * @param zipCode the zipcode of the user
     */
    public void setZip(String zipCode) {
        zip = zipCode;
    }

    /**
     * Accesses this user's zip code
     *
     * @return this user's zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the weekly water goal
     *
     * @param weeklyWaterGoal the weekly water goal of the user
     */
    public void setWeeklyGoal(int weeklyWaterGoal) {
        weeklyGoal = weeklyWaterGoal;
    }

    /**
     * Accesses this user's weekly goal
     *
     * @return this user's weekly goal
     */
    public int getWeeklyGoal() {
        return weeklyGoal;
    }

    /**
     * Sets the name of the user
     *
     * @param userName the name of the user
     */
    public void setName(String userName) {
        name = userName;
    }

    /**
     * Accesses this user's name
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the payment period of the user (Quarterly, Yearly, etc)
     *
     * @param payPer the payment period of the user
     */
    public void setPaymentPeriod(String payPer) {
        paymentPeriod = payPer;
    }

    /**
     * Accesses data on how often the water bill is given (quarterly, monthly, yearly, or other)
     *
     * @return the payment period
     */
    public String getPaymentPeriod() {
        return paymentPeriod;
    }

    /**
     * Sets how many times the user brushes their teeth and for how long they brush each time
     *
     * @param brushNum  the number of times the user brushes their teeth
     * @param brushTime the amount of time the user takes to brush their teeth each time
     */
    public void setBrushTeeth(int brushNum, int brushTime) {
        brushTeethNum = brushNum;
        brushTeethTime = brushTime;
    }

//    public void leavesWaterOn() {
//       String ans = "Yes";
//
//        if (ans == "Yes") {
//           getBrushTeethNum();
//           getBrushTeethTime();
//        }
//        else {
//
//        }
//
//    }

    /**
     * Accesses the number of times a user brushes their teeth
     *
     * @return the number of times a user brushes their teeth
     */
    public int getBrushTeethNum() {
        return brushTeethNum;
    }

    /**
     * Accesses the amount of time a user brushes their teeth for
     *
     * @return the amount of time a user brushes their teeth for, in minutes
     */
    public int getBrushTeethTime() {
        return brushTeethTime;
    }

    /**
     * Sets whether or not the user takes a shower or bath
     *
     * @param typeWash a String that contains "Shower" or "Bath"
     */
    public void setWash(String typeWash) {
        wash = typeWash;
    }

    /**
     * Accesses data on whether the user generally showers or takes a bath
     *
     * @return a String; either "Shower" or "Bath"
     */
    public String getWash() {
        return wash;
    }

    /**
     * Sets the number of times the user takes either a bath or a shower
     *
     * @param numWash the number times the user showers or bathes a day
     */
    public void setnumWash(int numWash) {
        this.numWash = numWash;
    }

    /**
     * Accesses the number of times a day the user showers or takes a bath
     *
     * @return the number of times a day the user showers or takes a bath
     */
    public int getnumWash() {
        return numWash;
    }

    public String checkGoal() {
        double total = 0;

        for (int i = 0; i < tasks.size(); i++) {
            total = total + tasks.get(i).getAmt_gallons();
        }

        if (total <= weeklyGoal) {
            return "You met your weekly goal! You used " + total + " gallons and your goal was " + weeklyGoal + ".";
        }
        else {
            return "Try better next time! You used " + total + " gallons and your goal was " + weeklyGoal + ".";
        }
    }


//    /**
//     * Generates and returns a string representation of ----------------
//     * @return a string ----------------
//     */
//    @Override
//    public String toString() {
//        return "Your tasks are " + getTasks(); //+ " and you goal weekly goal is " + weeklyGoal + " for a household size of " + houseSize +
//                //" in " + zip + ".";
//    }

}