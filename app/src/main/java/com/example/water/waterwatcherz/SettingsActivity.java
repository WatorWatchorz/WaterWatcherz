package com.example.water.waterwatcherz;

import android.app.Activity;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by krish on 4/12/2018.
 */

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button profileButton_settings;
    private Button taskActivityButton_settings;
    private Button checklistButton_settings;
    private Button confirmButton_settings;
    private EditText nameEnter;
    private EditText householdsize;
    private EditText billamount;
    private EditText weeklygoal;
    private EditText timesBrushEntry;
    private EditText numBoSEntry;
    String name = "";
    Integer hhsize = 0;
    Integer billamt = 0;
    Integer wklygoal= 0;
    Integer numBoS = 0;
    Integer timesBrush = 0;
    String townName = "";
    String paymentPeriod = "";


    protected void onCreate(Bundle savedInstanceState) {
        final Migration MIGRATION_1_6 = new Migration(1, 6) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {
            }
        };

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

        nameEnter = findViewById(R.id.PersonName);
        householdsize = findViewById(R.id.NumPplEdit);
        billamount = findViewById(R.id.BillAmountEnter);
        weeklygoal = findViewById(R.id.GoalAmount);
        timesBrushEntry = findViewById(R.id.timesBrushEntry);
        numBoSEntry = findViewById(R.id.numBoSEntry);

        if (!nameEnter.getText().toString().isEmpty()){
             name = nameEnter.getText().toString();
        }

        if (!householdsize.getText().toString().isEmpty()){
             hhsize = Integer.parseInt(householdsize.getText().toString());
        }
        if (!billamount.getText().toString().isEmpty()){
             billamt = Integer.parseInt(billamount.getText().toString());
        }
        if (!weeklygoal.getText().toString().isEmpty()){
             wklygoal = Integer.parseInt(weeklygoal.getText().toString());
        }
        if (!timesBrushEntry.getText().toString().isEmpty()){
            timesBrush = Integer.parseInt(timesBrushEntry.getText().toString());
        }
        if (!numBoSEntry.getText().toString().isEmpty()){
            numBoS = Integer.parseInt(numBoSEntry.getText().toString());
        }
        if (!townSpinner.getSelectedItem().toString().isEmpty()){
            townName = townSpinner.getSelectedItem().toString();
        }

        if (!PaymentPeriodSpinner.getSelectedItem().toString().isEmpty()){
            paymentPeriod = townSpinner.getSelectedItem().toString();
        }






        profileButton_settings = (Button) findViewById(R.id.profile_settings);
        taskActivityButton_settings = (Button) findViewById(R.id.calendar_settings);
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
                User user = new User();
                user.setName(name);
                user.setHouseSize(hhsize);
                user.setBillamt(billamt);
                user.setWeeklyGoal(wklygoal);
                user.setBrushTeethNum(timesBrush);
                user.setNumWash(numBoS);
                user.setPaymentPeriod(paymentPeriod);
                Log.d(townName,"EDT townName");
                user.setTown(townName);

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_6)
                        .build();
                db.userDao().insertUser(user);

                String[] towns = {"Worcester","Leominster","Auburn","Shrewsbury","Westborough","Fitchburg","West Brookfield","Leicester","Sturbridge","Holden","Northborough","Gardner","Dudley","Webster","Millbury","Milford","Northbridge","Rutland","Southbridge","Athol","Charlton","Sutton","Grafton","Oxford","Clinton","Berlin","Brookfield","Spencer","West Boylston","Southborough","Winchendon","Hardwick","Boylston","Hopedale","Ashburnham","North Brookfield","Bolton","Hubbardston","East Brookfield","New Braintree","Phillipston","Mendon","Barre","Blackstone","Royalston","Harvard","Douglas","Lunenburg","Uxbridge","Westminster","Templeton"};
                int[] gallons = {57,55,53,54,56,59,30,44,49,51,55,72,50,49,60,49,48,43,51,53,53,52,64,58,55,53,60,54,54,68,72,53,68,52,60,44,53,53,53,53,53,53,49,64,53,53,59,57,51,49,47};
                Town[] townlist = new Town[towns.length];
                for (int i=0;i<towns.length;i++) {
                    Town town = new Town();
                    town.setTownname(towns[i]);
                    town.setGallons(gallons[i]);
                    townlist[i] = town;
                }
                db.townDao().insertAllTowns(Arrays.asList(townlist));
//                User user2 = db.userDao().getAllUsers().get(0);
//                Log.d(user2.toString(),"user");
//                String database_town = db.userDao().getAllUsers().get(0).getTown();
//                Log.d(database_town,"town");
//                List<Town> dbtownlist = db.townDao().getallTowns();
//                for (int i=0;i<dbtownlist.size();i++) {
//                    Log.d(dbtownlist.get(i).toString(),"townlist");
//                }
//                Town town = db.townDao().getTownfromName(database_town);
//                Integer database_gallons = town.getGallons();
//                TextView goalHowTo = findViewById(R.id.goalHowTo);
//                goalHowTo.setText("Choose a weekly goal based off of your town's average water use per person per day. Your town's average water use per day is: " + Integer.toString(database_gallons));
            }});



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