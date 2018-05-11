package com.example.water.waterwatcherz;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.arch.persistence.db.SupportSQLiteDatabase;
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
    ListView tasktest_listview;
    WaterTask task1;
    int WaterTaskId;
    int id;


    final Migration MIGRATION_1_6 = new Migration(1, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_6)
                .build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist);

        Bundle bundle = getIntent().getExtras();

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
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_6)
                        .build();

                EditText numdeleteEnter = findViewById(R.id.numDelete);
                if(!numdeleteEnter.getText().toString().isEmpty()) {
                    int numdeleteInt = Integer.parseInt(numdeleteEnter.getText().toString());
                    db.waterTaskDao().deleteWaterTasks(waterTasks.get(numdeleteInt-1));
                }

//            for(WaterTask task1: waterTasks){
//                for(int i=0;i<waterTasks.size();i++) {
//
//                    if (id == task1.getUserid()) {
//                        int place = i;
//                        db.waterTaskDao().deleteWaterTasks(waterTasks.get(place));
//                    }
//                }
//            }
                }
        });

//        for(int i=0;i<waterTasks.size();i++) {
//
//            Log.d(waterTasks.get(i).toString(),"WaterTasks");
//        }
        waterTasks = db.waterTaskDao().getAllWaterTasks();

        tasktest_listview = findViewById(R.id.taskstest_listview1);
        ArrayAdapter<WaterTask> myAdapter =  new ArrayAdapter<WaterTask>(this,android.R.layout.simple_list_item_1,waterTasks);
        tasktest_listview.setAdapter(myAdapter);

        tasktest_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                task1 =(WaterTask) tasktest_listview.getItemAtPosition(position);
                WaterTaskId = task1.getUserid();
            }
        });
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