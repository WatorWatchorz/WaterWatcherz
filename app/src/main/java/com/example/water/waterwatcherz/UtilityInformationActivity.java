package com.example.water.waterwatcherz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by krish on 4/12/2018.
 */

public class UtilityInformationActivity  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utility_bill_information);
        Bundle bundle = getIntent().getExtras();
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
