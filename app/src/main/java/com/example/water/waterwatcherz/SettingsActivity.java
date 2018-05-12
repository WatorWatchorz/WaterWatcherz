package com.example.water.waterwatcherz;

import android.app.Activity;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
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

import java.util.Arrays;
import java.util.List;

/**
 * Created by krish on 4/12/2018.
 */

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button profileButton_settings;
    private Button taskActivityButton_settings;
    private Button confirmButton_settings;

    final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

        }
    };

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

        confirmButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
             String name = "";
             Integer hhsize = 0;
             Integer billamtgallons = 0;
             Integer goalamt = 0;
             Integer timesBrush = 0;
             Integer numBoS = 0;
                EditText nameEdit = findViewById(R.id.PersonName);
                if (!nameEdit.getText().toString().isEmpty()) {
                     name = nameEdit.getText().toString();
                }
                EditText householdSize = findViewById(R.id.NumPplEdit);
                if (!householdSize.getText().toString().isEmpty()) {
                     hhsize = Integer.parseInt(householdSize.getText().toString());
                }
                EditText billAmountGallons = findViewById(R.id.BillAmountEnter);
                if (!billAmountGallons.getText().toString().isEmpty()) {
                     billamtgallons = Integer.parseInt(billAmountGallons.getText().toString());
                }

                EditText goalAmount = findViewById(R.id.GoalAmount);
                if (!goalAmount.getText().toString().isEmpty()) {
                     goalamt = Integer.parseInt(goalAmount.getText().toString());

                }

                EditText timesBrushEntry = findViewById(R.id.timesBrushEntry);
                if (!timesBrushEntry.getText().toString().isEmpty()) {
                     timesBrush = Integer.parseInt(timesBrushEntry.getText().toString());

                }


                EditText numBoSEntry = findViewById(R.id.numBoSEntry);
                if (!numBoSEntry.getText().toString().isEmpty()) {
                     numBoS = Integer.parseInt(numBoSEntry.getText().toString());
                }
                User user = new User();
                user.setName(name);
                user.setHouseSize(hhsize);
                user.setWeeklyGoal(goalamt);
                user.setBrushTeethNum(timesBrush);
                user.setNumWash(numBoS);

                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Database")
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_2)
                        .build();

                db.userDao().insertUser(user);
                String [] townnames = {"Worcester","Leominster","Auburn","Shrewsbury","Westborough","Fitchburg","West Brookfield","Leicester","Sturbridge","Holden","Northborough","Gardner","Dudley","Webster","Millbury","Milford","Northbridge","Rutland","Southbridge","Athol","Charlton","Sutton","Grafton","Oxford","Clinton","Berlin","Brookfield","Spencer","West Boylston","Southborough","Winchendon","Hardwick","Boylston","Hopedale","Ashburnham","North Brookfield","Bolton","Hubbardston","East Brookfield","New Braintree","Phillipston","Mendon","Barre","Blackstone","Royalston","Harvard","Douglas","Lunenburg","Uxbridge","Westminster","Templeton"};
                int [] gallonsperpersonperday = {57,55,53,54,56,59,30,44,49,51,55,72,50,49,60,49,48,43,51,53,53,52,64,58,55,53,60,54,54,68,72,53,68,52,60,44,53,53,53,53,53,53,49,64,53,53,59,57,51,49,47};
                Town[] towns = new Town[townnames.length];
                for(int i=0;i<townnames.length; i++) {
                    Town town = new Town();
                    town.setTownname(townnames[i]);
                    town.setGallons(gallonsperpersonperday[i]);
                    towns[i] = town;
                }
                List townsList = Arrays.asList(towns);
                db.townDao().insertAllTowns(townsList);
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


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
   }
}