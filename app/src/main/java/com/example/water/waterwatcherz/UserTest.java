package com.example.water.waterwatcherz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by WaterWatcherz on 4/2/18.
 */

public class UserTest {

    public static void main(String[] args) {
        ArrayList<WaterTask> testTask = new ArrayList<>();
        testTask.add(new WaterTask("Water Lawn", 1, 3, 2018,
                1, 2, 2, 7));
        User user = new User(testTask, 4, "01605", 15, "Chris","Quarterly", 2, 2, "Shower",1);

        System.out.println(user.getTasks());
        System.out.println(user.getHouseSize());
        System.out.println(user.getZip());
        System.out.println(user.getWeeklyGoal());
        System.out.println(user.getName());
        System.out.println(user.getPaymentPeriod());
        System.out.println(user.getBrushTeethNum());
        System.out.println(user.getBrushTeethTime());
        System.out.println(user.getWash());
        System.out.println(user.getnumWash());

        User user2 = new User();
        System.out.println(user2.getTasks());
        System.out.println(user2.getHouseSize());
        System.out.println(user2.getZip());
        System.out.println(user2.getWeeklyGoal());
        System.out.println(user2.getName());
        System.out.println(user2.getPaymentPeriod());
        System.out.println(user2.getBrushTeethNum());
        System.out.println(user2.getBrushTeethTime());
        System.out.println(user2.getWash());
        System.out.println(user2.getnumWash());

    }
}
