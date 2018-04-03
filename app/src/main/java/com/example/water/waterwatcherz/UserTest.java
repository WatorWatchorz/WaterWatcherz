package com.example.water.waterwatcherz;

/**
 * Created by gnandyalam on 4/2/18.
 */

public class UserTest {

    public static void main(String[] args) {
        User user = new User("Showering", 4, "01605", 15);
        System.out.println(user.getTask());
        System.out.println(user.getHouseSize());
        System.out.println(user.getZip());
        System.out.println(user.getWeeklyGoal());
    }
}
