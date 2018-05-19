package com.example.water.waterwatcherz;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by krish on 4/12/2018.
 */

public class HomeActivity  extends AppCompatActivity {

    List<User> users;
    private Button taskActivityButton_home;
    private Button settingsButton_home;
    private Button checklistButton_home;
    private ProgressBar progBar;

    static final Migration MIGRATION_1_2 = new Migration(1, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Database")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build();
        double sum = 0;
        List<WaterTask> waterTasks = db.waterTaskDao().getAllWaterTasks();
        for (int i = 0; i < waterTasks.size(); i++) {
            sum = sum + waterTasks.get(i).getAmt_gallons();
        }
        List<User> users = db.userDao().getAllUsers();
        progBar = findViewById(R.id.BarOfProgress);

        if (users.isEmpty()) {
            User user = new User();
            db.userDao().insertUser(user);
        } else {
            User user = users.get(0);
            int perc = 0;
            if (user.getWeeklyGoal() != 0) {
                int  gallonsused = (int)((sum) + 2.0*7*user.getBrushTeethNum());
                perc = (int) ((100.0*sum) + 2.0*7*user.getBrushTeethNum())/ user.getWeeklyGoal();
                TextView gallons = findViewById(R.id.gallonsused);
                gallons.setText("Gallons Used: " + gallonsused);
            } else {
                perc = 0;
            }
            if (perc > 99) {
                perc = 99;
            }
            progBar.setProgress(perc);
        }

        taskActivityButton_home = (Button) findViewById(R.id.calendar_home);
        settingsButton_home = (Button) findViewById(R.id.settings_home);
        checklistButton_home = (Button) findViewById(R.id.checklist_home);

        taskActivityButton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        });
        settingsButton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSettings();
            }
        });
        checklistButton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openChecklist();
            }
        });

    }

    public void openChecklist() {
        Intent intent = new Intent(this, ChecklistActivity.class);
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

