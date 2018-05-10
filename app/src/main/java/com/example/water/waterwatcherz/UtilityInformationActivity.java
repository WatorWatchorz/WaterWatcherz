package com.example.water.waterwatcherz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by krish on 4/12/2018.
 */

public class UtilityInformationActivity  extends AppCompatActivity {

    private Button profileButton_utilityinfo;
    private Button taskActivityButton_utilityinfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utility_bill_information);
        Bundle bundle = getIntent().getExtras();

        profileButton_utilityinfo = (Button) findViewById(R.id.profile);
        taskActivityButton_utilityinfo = (Button) findViewById(R.id.calendar);

        profileButton_utilityinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });
        taskActivityButton_utilityinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openTaskActivity();
            }
        });
    }

//    public void storeWaterUsed(){
//        EditText waterUsed = (EditText) findViewById(R.id.waterUsed);
//       Double waterUsedDbl = 0.0;
//        if (!waterUsed.toString().isEmpty()) {
//            waterUsedDbl = Double.parseDouble(waterUsed.toString());
//        }
//        /*
//        Intent intent = new Intent (this, SQLHandler.class);
//
//        intent.putExtra("Water Used",waterUsedDbl);
//        startActivity(intent);
//        */
//        }

    public void openProfile() {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

    public void openTaskActivity() {
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivity(intent);
    }

}