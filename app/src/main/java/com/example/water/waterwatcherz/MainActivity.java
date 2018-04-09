package com.example.water.waterwatcherz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String [] args)
    {
        User bob = new User();
        Group g = new Group();

        System.out.println("GROUP CODE: " + g.getGroupCode());
        System.out.println("OWNER: " + g.getOwner());
        System.out.print("USERS: " + g.getUsers());
        g.addUser(bob);
        g.setOwner(bob);
        g.setGroupCode(234);
        System.out.println("");
        System.out.println("GROUP CODE: " + g.getGroupCode());
        System.out.println("OWNER: " + g.getOwner());
        System.out.print("USERS: " + g.getUsers());
    }
}
