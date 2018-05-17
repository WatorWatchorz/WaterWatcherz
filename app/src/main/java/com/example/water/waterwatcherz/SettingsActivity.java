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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import java.util.List;

/**
 * Created by krish on 4/12/2018.
 */

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button profileButton_settings;
    private Button taskActivityButton_settings;
    private Button checklistButton_settings;
    private Button confirmButton_settings;
//    private EditText nameEnter;
//    private EditText householdsize;
//    private EditText billamount;
//    private EditText weeklygoal;
//    private EditText timesBrushEntry;
//    private EditText numBoSEntry;
    String name = "";
    Integer hhsize = 0;
    Integer billamt = 0;
    Integer wklygoal= 0;
    Integer numBoS = 0;
    Integer timesBrush = 0;
    String townName = "";
    String paymentPeriod = "";

    final Migration MIGRATION_1_2 = new Migration(1, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
        }
    };





    protected void onCreate(Bundle savedInstanceState) {

         AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Bundle bundle = getIntent().getExtras();



        final Spinner townSpinner = findViewById(R.id.townDropDown);
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

        profileButton_settings = (Button) findViewById(R.id.profile_settings);
        checklistButton_settings = (Button) findViewById(R.id.checklist_settings);
        confirmButton_settings = (Button) findViewById(R.id.confirm);
        taskActivityButton_settings = (Button) findViewById(R.id.calendar_settings);

        profileButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });
        checklistButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openChecklist();
            }});
        taskActivityButton_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openTaskActivity();
            }});



        User user = new User();
        db.userDao().insertUser(user);

        confirmButton_settings.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_2)
                        .build();

                name = ((EditText)findViewById(R.id.PersonName)).getText().toString();
                hhsize = Integer.parseInt(((EditText)findViewById(R.id.NumPplEdit)).getText().toString());
                billamt = Integer.parseInt(((EditText)findViewById(R.id.BillAmountEnter)).getText().toString());
                wklygoal = Integer.parseInt(((EditText)findViewById(R.id.GoalAmount)).getText().toString());
                timesBrush = Integer.parseInt(((EditText)findViewById(R.id.timesBrushEntry)).getText().toString());
                User user = db.userDao().getAllUsers().get(0);
                user.setName(name);
                user.setHouseSize(hhsize);
                user.setBillamt(billamt);
                user.setWeeklyGoal(wklygoal);
                user.setBrushTeethNum(timesBrush);
              //  user.setNumWash(numBoS);
                user.setPaymentPeriod(paymentPeriod);
                Log.d(townName,"EDT townName");
                user.setTown(townName);

                db.userDao().deleteTables();
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
                Log.d("towntest",db.townDao().getallTowns().toArray().toString());
                List<User> users = db.userDao().getAllUsers();
                User dbuser = users.get(users.size()-1);
                String town = dbuser.getTown();

                int town1id = db.townDao().getidfromName(town);
                List<Town> towns2 = db.townDao().getallTowns();
                Town town1 = new Town();
                for(int i=0;i<towns2.size();i++){
                    if(towns2.get(i).getId()==town1id) {
                         town1 = towns2.get(i);
                    }
                }

                Log.d("testertester",town);
                //int dbgallons = town1.getGallons();
                int index = townSpinner.getSelectedItemPosition();
                Integer gallonnum = gallons[index];

                TextView goalHowto = findViewById(R.id.goalHowTo);
                goalHowto.setText(getResources().getString(R.string.goalHowTo)+" " + Integer.toString(gallonnum));

            }});
    }

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