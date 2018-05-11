package com.example.water.waterwatcherz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by krish on 4/12/2018.
 */

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button profileButton_settings;
    private Button taskActivityButton_settings;
    private Button checklistButton_settings;
    private Button confirmButton_settings;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Bundle bundle = getIntent().getExtras();

        Spinner townSpinner = findViewById(R.id.townDropDown);
        ArrayAdapter<CharSequence> adapterTown = ArrayAdapter.createFromResource(this,
                R.array.towns_array, android.R.layout.simple_spinner_item);
        adapterTown.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        townSpinner.setAdapter(adapterTown);
        townSpinner.setOnItemSelectedListener(this);

        Spinner PaymentPeriodSpinner = findViewById(R.id.PaymentPeriods);
        ArrayAdapter<CharSequence> adapterPayment = ArrayAdapter.createFromResource(this,
                R.array.paymentperiods_array, android.R.layout.simple_spinner_item);
        adapterPayment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PaymentPeriodSpinner.setAdapter(adapterPayment);
        PaymentPeriodSpinner.setOnItemSelectedListener(this);

        Spinner bOsSpinner = findViewById(R.id.bathORshower);
        ArrayAdapter<CharSequence> adapterbOs = ArrayAdapter.createFromResource(this,
                R.array.bathORshower_array, android.R.layout.simple_spinner_item);
        adapterbOs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bOsSpinner.setAdapter(adapterbOs);
        bOsSpinner.setOnItemSelectedListener(this);

        profileButton_settings = (Button) findViewById(R.id.settings_profile);
        taskActivityButton_settings = (Button) findViewById(R.id.settings_addtask);
        checklistButton_settings = (Button) findViewById(R.id.checklist_settings);

        confirmButton_settings = (Button) findViewById(R.id.confirm);

        profileButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });
        taskActivityButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openTaskActivity();
            }
        });
        checklistButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openChecklist();
            }});

        confirmButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

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
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public void openTaskActivity() {
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivity(intent);
    }

    public void openChecklist() {
        Intent intent = new Intent(this, ChecklistActivity.class);
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
   }
}