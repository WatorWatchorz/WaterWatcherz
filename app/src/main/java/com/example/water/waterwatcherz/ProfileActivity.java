package com.example.water.waterwatcherz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
/**
 * Created by krish on 4/12/2018.
 */

public class ProfileActivity  extends AppCompatActivity {

    private Button taskActivityButton_profile;
    private Button profilebutton_profile;
    private Button utilitybutton_profile;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_info);
        Bundle bundle = getIntent().getExtras();


        taskActivityButton_profile = (Button) findViewById(R.id.calendar_houseinfo);
        utilitybutton_profile = (Button) findViewById(R.id.utilitybutton_houseinfo);
        profilebutton_profile = (Button) findViewById(R.id.profile_houseinfo);


        taskActivityButton_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        });
        profilebutton_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });
        utilitybutton_profile.setOnClickListener(new View.OnClickListener() {
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

    public void setUserInformation() {
        EditText householdsizetext = (EditText) findViewById(R.id.NumPplEDT);
        if (!householdsizetext.toString().isEmpty()) {
            Integer householdsize = Integer.parseInt(householdsizetext.getText().toString());
            Log.d("HOUSEHOLD SIZE", householdsizetext.toString());
            User user = new User();
            user.setHouseSize(householdsize);
        }
    }

}
