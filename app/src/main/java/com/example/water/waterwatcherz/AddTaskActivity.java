package com.example.water.waterwatcherz;

import android.content.Intent;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
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


public class AddTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button profileButton_addtask;
    private Button settingsButton_addtask;
    private Button checkButton_addtask;
    private Button confirmButton_addtask;

    final Migration MIGRATION_1_2 = new Migration(1, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

        }
    };
    Spinner taskSpinner;
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        taskSpinner = findViewById(R.id.taskDropDown);
        Bundle bundle = getIntent().getExtras();

                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                        R.array.tasks_array, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                taskSpinner.setAdapter(adapter1);
                taskSpinner.setOnItemSelectedListener(this);
                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Database")
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_2)
                        .build();

                profileButton_addtask = (Button) findViewById(R.id.profile_addtask);
                settingsButton_addtask = (Button) findViewById(R.id.settings_addtask);
                checkButton_addtask = (Button) findViewById(R.id.checklist_addtask);
                confirmButton_addtask = (Button) findViewById(R.id.confirm_dbTest);

                profileButton_addtask.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        openProfile();
                    }
                });
                settingsButton_addtask.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        openSettings();
                    }
                });
                checkButton_addtask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openChecklist();
            }
        });
        confirmButton_addtask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

            }

    public void openProfile() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public void openSettings() {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }
    public void openChecklist() {
        Intent intent = new Intent(this,ChecklistActivity.class);
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
       Integer week;
       Integer month;
       Integer duration;

        parent.getItemAtPosition(pos);
        EditText monthEnter = findViewById(R.id.monthEDT);
        if (!monthEnter.getText().toString().isEmpty()) {
             month = Integer.parseInt(monthEnter.getText().toString());
        }
        else{month=0;}

        EditText weekEnter = findViewById(R.id.weekEDT);
        if(!weekEnter.getText().toString().isEmpty()) {
             week = Integer.parseInt(weekEnter.getText().toString());
        }
        else{week=0;}

        EditText durationEnter = findViewById(R.id.duration);
        if(!durationEnter.getText().toString().isEmpty()){
            duration = Integer.parseInt(durationEnter.getText().toString());
        }
        else{duration=0;}

        String taskName = taskSpinner.getSelectedItem().toString();
        WaterTask waterTask = new WaterTask();
        waterTask.setTaskName(taskName);
        waterTask.setMonth(month);
        waterTask.setWeek(week);
        waterTask.setDuration(duration);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build();
        db.waterTaskDao().insertWaterTask(waterTask);
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
