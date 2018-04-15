package com.example.water.waterwatcherz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by krish on 4/12/2018.
 */

public class AddTaskActivity  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        Bundle bundle = getIntent().getExtras();
    }
}
