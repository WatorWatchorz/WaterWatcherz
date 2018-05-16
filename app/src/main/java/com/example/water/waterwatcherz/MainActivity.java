package com.example.water.waterwatcherz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button profilebutton_main;
    private Button taskActivityButton_main;
    private Button settingsbutton_main;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.watericon);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        taskActivityButton_main = (Button) findViewById(R.id.calendar_home);
        profilebutton_main = (Button) findViewById(R.id.profile_home);
        settingsbutton_main = findViewById(R.id.settings_home);

        taskActivityButton_main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        });

        settingsbutton_main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSettingsActivity();
            }
        });


    }

    public void openTaskActivity() {
        Intent intent = new Intent(this,DatabaseTest.class);
        startActivity(intent);
    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}