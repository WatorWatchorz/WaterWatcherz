package com.example.water.waterwatcherz;

import android.content.Intent;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by krish on 4/12/2018.
 */


public class AddTaskActivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button profileButton_addtask;
    private Button settingsButton_addtask;
    private Button checklistButton_addtask;
    private Button confirm_dbTest2;


    final Migration MIGRATION_1_2 = new Migration(1, 2) {
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

            Button confirm_dbTest2 = findViewById(R.id.confirm_dbTest);
            confirm_dbTest2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    updateDb();
                }
            });

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
        checklistButton_addtask = (Button) findViewById(R.id.checklist_addtask);

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
        checklistButton_addtask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openChecklist();
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
        Intent intent = new Intent(this, ChecklistActivity.class);
        startActivity(intent);
    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        Integer week = 0;
        Integer month = 0;
        parent.getItemAtPosition(pos);
        EditText monthEnter = findViewById(R.id.monthEDT);
        EditText weekEnter = findViewById(R.id.weekEDT);
        if (!monthEnter.getText().toString().isEmpty()) {
             month = Integer.parseInt(monthEnter.getText().toString());
        }
        if(!weekEnter.getText().toString().isEmpty()) {
             week = Integer.parseInt(weekEnter.getText().toString());
        }

        String taskName = taskSpinner.getSelectedItem().toString();
        WaterTask waterTask = new WaterTask();
        waterTask.setTaskName(taskName);
        waterTask.setWeek(week);
    }

    protected void updateDb() {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database1")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build();
        EditText month = findViewById(R.id.monthEDT);
        String monthString=month.getText().toString();
        int monthInt=Integer.parseInt(monthString);
        if(!monthString.isEmpty()) {
            WaterTask aTask = new WaterTask();
            //jim.setId(1);
            aTask.setMonth(monthInt);
            EditText week = findViewById(R.id.weekEDT);
            String weekString=month.getText().toString();
            int weekInt=Integer.parseInt(monthString);
            if(!weekString.isEmpty()) {
                aTask.setWeek(weekInt);
                String taskString = taskSpinner.getSelectedItem().toString();
                if (!taskString.isEmpty()) {
                    aTask.setTaskName(taskString);
                    EditText duration = findViewById(R.id.duration);
                    String durationString = duration.getText().toString();
                    int durationInt = Integer.parseInt(durationString);
                    if (!durationString.isEmpty()) {
                        db.waterTaskDao().insertWaterTask(aTask);
                    }
                }
            }
         //   waterTask.setTaskName(name);
            //db.userDao().insertUser(jim);

        }
        List<WaterTask> waterTaskslist = db.waterTaskDao().getAllWaterTasks();
        ArrayAdapter<WaterTask> TasksAdapter = new ArrayAdapter<WaterTask>(this, android.R.layout.simple_list_item_1, waterTaskslist);
        ListView listView1 = findViewById(R.id.taskstest_listview);
        listView1.setAdapter(TasksAdapter);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
