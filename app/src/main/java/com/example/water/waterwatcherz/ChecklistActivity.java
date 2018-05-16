package com.example.water.waterwatcherz;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


/**
 * Created by eesha on 5/10/2018.
 */

public class ChecklistActivity  extends AppCompatActivity {
    private Button profileButton_checklist;
    private Button settingsButton_checklist;
    private Button taskActivityButton_checklist;
    private Button deleteTestButton;
    List<WaterTask> waterTasks;
    ArrayAdapter<WaterTask> myAdapter;
    ListView tasktest_listview;
    int id;
    int numdeleteInt;


    final Migration MIGRATION_1_6 = new Migration(1, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Database")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_6)
                .build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist);

        profileButton_checklist = (Button) findViewById(R.id.profile_checklist);
        taskActivityButton_checklist = (Button) findViewById(R.id.calendar_checklist);
        settingsButton_checklist = (Button) findViewById(R.id.settings_checklist);

        deleteTestButton = (Button) findViewById(R.id.DeleteTask_checklist);


        profileButton_checklist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });
        taskActivityButton_checklist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        });
        settingsButton_checklist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSettings();
            }
        });

        deleteTestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Database")
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_6)
                        .build();
                EditText numdeleteEnter = findViewById(R.id.numDelete);
                if (!numdeleteEnter.getText().toString().isEmpty()) {
                    try {
                        numdeleteInt = Integer.parseInt(numdeleteEnter.getText().toString());
                    } catch (NumberFormatException e) {
                        numdeleteInt = 0;
                    }
                    if (numdeleteInt < waterTasks.size() && numdeleteInt >= 1) {
                        db.waterTaskDao().deleteWaterTasks(waterTasks.get(numdeleteInt - 1));
                        myAdapter.remove(waterTasks.get(numdeleteInt - 1));
                        numdeleteEnter.setText("");
                    }
                }
            }
        });

        waterTasks = db.waterTaskDao().getAllWaterTasks();

        tasktest_listview = findViewById(R.id.taskstest_listview1);
        myAdapter = new ArrayAdapter<WaterTask>(this, android.R.layout.simple_list_item_1, waterTasks);
        tasktest_listview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    public void openProfile() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openTaskActivity() {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    public void openSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}