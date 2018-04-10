package com.example.water.waterwatcherz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by WaterWatcherz on 4/2/18.
 */

public class UserTest {

    public static void main(String[] args) {
        ArrayList<WaterTask> testTask = new ArrayList<WaterTask>();
        WaterTask activity = new WaterTask("Shower", 1, 3, 2018, 1, 2, 8, 7);
        testTask.add(activity);
        User user = new User(testTask, 4, "01605", 15, "Chris","Quarterly");
        System.out.println(user.getTask());
        System.out.println(user.getHouseSize());
        System.out.println(user.getZip());
        System.out.println(user.getWeeklyGoal());
        System.out.println(user.getName());
        System.out.println(user.getPaymentPeriod());
        User user2 = new User();
        System.out.println(user2.getTask());
        System.out.println(user2.getHouseSize());
        System.out.println(user2.getZip());
        System.out.println(user2.getWeeklyGoal());
        System.out.println(user2.getName());
        System.out.println(user2.getPaymentPeriod());

    }
}
