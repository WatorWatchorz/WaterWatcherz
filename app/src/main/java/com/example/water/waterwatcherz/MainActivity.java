package com.example.water.waterwatcherz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Data
    User new_user;
    ArrayList<WaterTask> userTasks = new ArrayList<WaterTask>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkGoalMet() {
        EditText enterUsage = findViewById(R.id.enterWaterUsed);
        String waterUsedString = enterUsage.getText().toString();
        double waterUsed = new Double(Double.parseDouble(waterUsedString));
        if (waterUsed >  ) {

        }
    }

}
