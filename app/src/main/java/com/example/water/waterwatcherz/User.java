package com.example.water.waterwatcherz;

import android.arch.persistence.room.Entity;

import java.util.ArrayList;

import android.arch.persistence.room.ColumnInfo;

import android.arch.persistence.room.Entity;

import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

/**
 * Creates a unique User. Contains WaterTask objects and data on a user's household size,
 * zip code, and weekly water goal
 * Created by WaterWatcherz on 3/28/2018.
 */

@Entity
public class User
{

    public int getId() {
        return id;
    }

    public int getNumWash() {
        return numWash;
    }

    //Data
    //Stores the name of the user
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @Ignore
    private ArrayList<WaterTask> tasks;

    //Stores a list of water task objects
   // private ArrayList<WaterTask> tasks;
    //Stores the number of people in the user's household

    @ColumnInfo(name = "houseSize")
    private int houseSize;


    //Stores the numeric value of the weekly goal in gallons

    @ColumnInfo(name="weeklyGoal")
    private int weeklyGoal;
    //Stores data on whether the water bill is given quarterly, monthly, or yearly

    @ColumnInfo(name="paymentPeriod")
    private String paymentPeriod;
    //Stores the number of times the user brushes their teeth in a day

    @ColumnInfo(name="brushTeethNum")
    private int brushTeethNum;

    public void setId(int id) {
        this.id = id;
    }

/*    public void setTasks(ArrayList<WaterTask> tasks) {
        this.tasks = tasks;
    }
*/
    public void setBrushTeethNum(int brushTeethNum) {
        this.brushTeethNum = brushTeethNum;
    }

    public void setBrushTeethTime(int brushTeethTime) {
        this.brushTeethTime = brushTeethTime;
    }

    public void setNumWash(int numWash) {
        this.numWash = numWash;
    }
    //Stores the amount of time the user brushes their teeth for

    @ColumnInfo(name="brushTeethTime")
    private int brushTeethTime;
    //Stores data on whether the user generally showers or takes a bath

    @ColumnInfo(name="wash")
    private String wash;
    //Stores the number of times a day the user showers or takes a bath

    @ColumnInfo(name="numWash")
    private int numWash;
    //Constructor

    //take out zipcode

    /**
     * Constructs a new User object
     * @param userTask an ArrayList containing the user's WaterTask objects
     * @param houseNumber an integer value containing the number of people in the user's household
     * @param weeklyWaterGoal a String containing the user's weekly goal
     * @param userName a String containing the name of the user
     * @param paymentPeriod a string containing data on how often the water bill is delivered
     * @param brushTeethNum the number of times the user brushes their teeth in a day
     * @param brushTeethTime the amount of time the user brushes their teeth for
     * @param wash a String that stores whether the user generally showers or takes a bath
     * @param numWash the number of times the user generally shower or takes a bath in a day
     */
    public User(ArrayList<WaterTask> userTask, int houseNumber, int weeklyWaterGoal, String userName,
                String paymentPeriod, int brushTeethNum, int brushTeethTime, String wash, int numWash) {
        tasks = userTask;
        houseSize = houseNumber;
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
     * @param houseSize_in the user's house size
     */
    public void setHouseSize (int houseSize_in) {
        houseSize = houseSize_in;
    }

    /**
     * Accesses this user's house size
     * @return this user's house size
     */
    public int getHouseSize() {
        return houseSize;
    }

    /**
     * Gets a string containing all the user's water tasks
     * @return the user's water tasks
     */
    public String getTasks() {
        String str = "";
        for(int i = 0; i < tasks.size(); i++)
        {str = str + (tasks.get(i)).getTaskName();}
        return str;
    }

    /**
     * Adds a water task to the user's list of water tasks
     * @param userTask a new water task
     */
    public void setUserTask(WaterTask userTask){tasks.add(userTask);}

    /**
     * Sets the weekly water goal
     * @param weeklyWaterGoal the weekly water goal of the user
     */
    public void setWeeklyGoal(int weeklyWaterGoal) {weeklyGoal = weeklyWaterGoal;}

    /**
     * Accesses this user's weekly goal
     * @return this user's weekly goal
     */
    public int getWeeklyGoal() {
        return weeklyGoal;
    }

    /**
     * Sets the name of the user
     * @param userName the name of the user
     */
    public void setName(String userName){name = userName;}

    /**
     * Accesses this user's name
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the payment period of the user (Quarterly, Yearly, etc)
     * @param payPer the payment period of the user
     */
    public void setPaymentPeriod(String payPer) {paymentPeriod = payPer;}

    /**
     * Accesses data on how often the water bill is given (quarterly, monthly, yearly, or other)
     * @return the payment period
     */
    public String getPaymentPeriod()
    {
        return paymentPeriod;
    }

    /**
     * Sets how many times the user brushes their teeth and for how long they brush each time
     * @param brushNum the number of times the user brushes their teeth
     * @param brushTime the amount of time the user takes to brush their teeth each time
     */
    public void setBrushTeeth(int brushNum, int brushTime)
    {
        brushTeethNum = brushNum;
        brushTeethTime = brushTime;
    }

    /**
     * Accesses the number of times a user brushes their teeth
     * @return the number of times a user brushes their teeth
     */
    public int getBrushTeethNum(){return brushTeethNum;}

    /**
     * Accesses the amount of time a user brushes their teeth for
     * @return the amount of time a user brushes their teeth for, in minutes
     */
    public int getBrushTeethTime(){return brushTeethTime;}

    /**
     * Sets whether or not the user takes a shower or bath
     * @param typeWash a String that contains "Shower" or "Bath"
     */
    public void setWash(String typeWash) {wash = typeWash;}

    /**
     * Accesses data on whether the user generally showers or takes a bath
     * @return a String; either "Shower" or "Bath"
     */
    public String getWash (){return wash;}

    /**
     * Sets the number of times the user takes either a bath or a shower
     * @param numWash the number times the user showers or bathes a day
     */
   // public void setnumWash(int numWash) {this.numWash = numWash;}

    /**
     * Accesses the number of times a day the user showers or takes a bath
     * @return the number of times a day the user showers or takes a bath
     */
    public int getnumWash(){return numWash;}


 //UNFINISHED vvvvvvvvvvvvv NEED??

    /**
     * Generates and returns a string representation of ----------------
     * @return a string ----------------
     */
    @Override
    public String toString() {
      //  return "Your tasks are " + getTasks(); //+ " and you goal weekly goal is " + weeklyGoal + " for a household size of " + houseSize +
                //" in " + zip + ".";
        return name+houseSize+weeklyGoal+numWash;
    }

}