package com.example.water.waterwatcherz;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


public class DatabaseTest extends AppCompatActivity {

    static final Migration MIGRATION_1_6 = new Migration(1, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
        Button confirm_dbTest = findViewById(R.id.confirm_dbTest);
        confirm_dbTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDb();
            }
        });
    }
        protected void updateDb() {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_6)
                    .build();
            EditText nameEnter = findViewById(R.id.nameEnter);
            String name = nameEnter.getText().toString();
            if(!name.isEmpty()) {
                User jim = new User();
                //jim.setId(1);
                jim.setName(name);
                jim.setBrushTeethTime(5);
                WaterTask waterTask = new WaterTask();
                waterTask.setTaskName(name);
                db.waterTaskDao().insertWaterTask(waterTask);
                //db.userDao().insertUser(jim);

                }
            //List<WaterTask> waterTasks = db.waterTaskDao().getAllWaterTasks();
            List<Town> towns = db.townDao().getallTowns();
            ArrayAdapter<Town> myAdapter = new ArrayAdapter<Town>(this, android.R.layout.simple_list_item_1, towns);
            ListView listView = findViewById(R.id.simple_listview);
            listView.setAdapter(myAdapter);
        }
}
