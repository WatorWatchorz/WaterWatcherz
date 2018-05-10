package com.example.water.waterwatcherz;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Data
    User new_user;
    ArrayList<WaterTask> userTasks = new ArrayList<WaterTask>();

    private Button profilebutton_main;
    private Button taskActivityButton_main;
    private Button listview_main;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      /*  View.OnClickListener taskActivityListener;
        View.OnClickListener profileListener;
        View.OnClickListener utilityListener;
       taskActivityListener = new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        };
        profileListener = new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        };
        utilityListener = new View.OnClickListener() {
            public void onClick(View v) {
                openUtiltyInformation();
            }
        };
*/

        taskActivityButton_main = (Button) findViewById(R.id.calendar_home);
        profilebutton_main = (Button) findViewById(R.id.profile_home);
        //listview_home = (Button) findViewById(R.id.listview);


/*
        //setting all buttons to have the same onClickListener
        taskActivityButton_home.setOnClickListener(taskActivityListener);
        taskActivityButton_addTask.setOnClickListener(taskActivityListener);
        taskActivityButton_profile.setOnClickListener(taskActivityListener);
        utilitybutton_home.setOnClickListener(utilityListener);
        utilitybutton_addTask.setOnClickListener(utilityListener);
        utilitybutton_profile.setOnClickListener(utilityListener);
        profilebutton_home.setOnClickListener(profileListener);
        profilebutton_addTask.setOnClickListener(profileListener);
        profilebutton_profile.setOnClickListener(profileListener);
*/

        profilebutton_main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });
        taskActivityButton_main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        });
        /*listview_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listView();
            }
        });*/

    }

    public void openProfile() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public void openTaskActivity() {
        Intent intent = new Intent(this,DatabaseTest.class);
        startActivity(intent);
    }

    public void listView() {
        Intent intent  = new Intent(this, DatabaseTest.class);
        startActivity(intent);
    }

}