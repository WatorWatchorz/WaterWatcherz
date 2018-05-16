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
        Bundle bundle = getIntent().getExtras();
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.watericon);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Database")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build();
        double sum = 0;
        List<WaterTask> waterTasks = db.waterTaskDao().getAllWaterTasks();
        for (int i = 0; i < waterTasks.size(); i++) {
            sum = sum + waterTasks.get(i).getAmt_gallons();
        }
        Log.d("SUM ", String.valueOf(sum));
        List<User> users = db.userDao().getAllUsers();
        Log.d("HOME ACTIVITY", "users list: " + users.toString());
        progBar = findViewById(R.id.BarOfProgress);

        if (users.isEmpty()) {
            User user = new User();
            db.userDao().insertUser(user);
        } else {
            User user = users.get(0);
            Log.d("HOME ACTIVITY", "user obj exists");
            int perc = 0;
            Log.d("HOME ACTIVIDAD", "#SquadGoals: " + String.valueOf(user.getWeeklyGoal()));
            if (user.getWeeklyGoal() != 0) {
                perc = (int) sum / user.getWeeklyGoal();
                Log.d("HOME ACTIVITY", "Perc = " + String.valueOf(perc));
            } else {
                perc = 0;
                Log.d("PERC", "there are no goals yet");
            }
            if (perc > 99) {
                perc = 99;
                Log.d("HOME ACTIVITY", "Perc" + String.valueOf(perc));
            }
            progBar.setProgress(perc);
            Log.d("HOME ACTIVITY", "progBar progress" + String.valueOf(progBar.getProgress()));
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

