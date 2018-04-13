package com.example.water.waterwatcherz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Data
    User new_user;
    ArrayList<WaterTask> userTasks = new ArrayList<WaterTask>();
    private Button taskActivityButton_home;
    private Button profilebutton_home;
    private Button utilitybutton_home;
    private Button taskActivityButton_addTask;
    private Button profilebutton_addTask;
    private Button utilitybutton_addTask;
    private Button taskActivityButton_profile;
    private Button profilebutton_profile;
    private Button utilitybutton_profile;

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
        taskActivityButton_home = (Button) findViewById(R.id.calendarhome);
        utilitybutton_home = (Button) findViewById(R.id.utilitybuttonhome);
        profilebutton_home = (Button) findViewById(R.id.profilehome);

        taskActivityButton_addTask = (Button) findViewById(R.id.calendarhome);
        utilitybutton_addTask = (Button) findViewById(R.id.utilitybuttonhome);
        profilebutton_addTask = (Button) findViewById(R.id.profilehome);

        taskActivityButton_profile = (Button) findViewById(R.id.calendarhome);
        utilitybutton_profile = (Button) findViewById(R.id.utilitybuttonhome);
        profilebutton_profile = (Button) findViewById(R.id.profilehome);
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



        taskActivityButton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        });
        profilebutton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });

        utilitybutton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUtiltyInformation();
            }
        });

    }



    public void openProfile() {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

    public void openTaskActivity() {
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivity(intent);
    }
    public void openUtiltyInformation() {
        Intent intent = new Intent(this,UtilityInformationActivity.class);
        startActivity(intent);
    }

}