package com.example.water.waterwatcherz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by krish on 4/12/2018.
 */

public class AddTaskActivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button profileButton_addtask;
    private Button settingsButton_addtask;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        Bundle bundle = getIntent().getExtras();

        Spinner taskSpinner = findViewById(R.id.taskDropDown);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.tasks_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taskSpinner.setAdapter(adapter1);
        taskSpinner.setOnItemSelectedListener(this);

        profileButton_addtask = (Button) findViewById(R.id.profile_addtask);
        settingsButton_addtask = (Button) findViewById(R.id.settings_addtask);


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
    }

    public void openProfile() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public void openSettings() {
        Intent intent = new Intent(this,SettingsActivity.class);
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
