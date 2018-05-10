package com.example.water.waterwatcherz;

/**
 * Created by WaterWatcherz on 4/3/2018.
 */

public class WaterTaskTester
    {
        public static void main(String[] args)
        {
            WaterTask activity = new WaterTask("Shower", 4, 3, 5,
                    2018, 5, 20, 1, 15);
            System.out.println(activity.getTaskName());
          //  System.out.println(activity.getDate());
            System.out.println(activity.getTime());
            System.out.println(activity.getDuration());
            System.out.println(activity.getAmt_gallons());
            activity.setWeek(3);
            System.out.println("week:" + activity.getWeek());


            WaterTask activity2 = new WaterTask();

            System.out.println(activity2.getTaskName());
         //   System.out.println(activity2.getDate());

            System.out.println(activity2.getWeek());
            System.out.println(activity2.getTime());
            System.out.println(activity2.getDuration());

        }
    }
