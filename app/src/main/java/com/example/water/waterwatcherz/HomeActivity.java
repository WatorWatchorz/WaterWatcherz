package com.example.water.waterwatcherz;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krish on 4/12/2018.
 */

public class HomeActivity  extends AppCompatActivity {//implements AdapterView.OnItemSelectedListener{

    List<User> users;
    private Button taskActivityButton_home;
    private Button settingsButton_home;
    private Button confirmbutton_home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundle = getIntent().getExtras();

        taskActivityButton_home = (Button) findViewById(R.id.calendar_home);
        settingsButton_home = (Button) findViewById(R.id.settings_home);

        taskActivityButton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openTaskActivity();
            }
        });
        settingsButton_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSettings();
            }
        });}

    //    confirmbutton_profile = (Button) findViewById(R.id.confirm);


//        confirmbutton_profile.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            EditText hhldsize = findViewById(R.id.NumPplEdit);
//            Log.d("TAG","onClick: firstName: " + hhldsize.getText().toString());
//            }
//        });
//
//        users = new ArrayList<>();
//        for (int i=0;i<10;i++) {
//            User user = new User();
//            user.setName("Krish");
//            users.add(user);
//        }
       /*
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        List<User> users = db.UserDao().getAllUsers();
        */
    //}

    public void openTaskActivity() {
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivity(intent);
    }
    public void openSettings() {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }
//
//    public void setUserInformation() {
//        EditText householdsizetext = (EditText) findViewById(R.id.NumPplEdit);
//        if (!householdsizetext.toString().isEmpty()) {
//            Integer householdsize = Integer.parseInt(householdsizetext.getText().toString());
//            Log.d("HOUSEHOLD SIZE", householdsizetext.toString());
//            User user = new User();
//            user.setHouseSize(householdsize);
//        }
//    }
//
//    public void storeInformation() {
//       // Spinner townSpinner = findViewById(R.id.townDropDown);
//        EditText numPplEdit = findViewById(R.id.NumPplEdit);
//        String numPplStr = numPplEdit.getText().toString();
//        if (!(numPplStr.isEmpty())) {
//            int numPpl = Integer.parseInt(numPplStr);
//        }
//        Context context = getApplicationContext();
//        String filename = "UserInformation";
//        File file = new File(context.getFilesDir(),filename);
//        FileOutputStream outputStream;
//        String fileContents = numPplStr;
//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"AppDatabase")
//                .allowMainThreadQueries()
//                .build();

        /*try{
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileIs = openFileInput(filename);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }

//    public void displayInformation() {
//        /*Context context = getApplicationContext();
//        String filename = "UserInformation";
//        File directory = context.getFilesDir();
//        File file = new File(directory, filename);
//
//        FileOutputStream outputStream;
//        try {
//            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
//            outputStream.write(fileContents.getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }*/
//    }

//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        // An item was selected. You can retrieve the selected item using
//        // parent.getItemAtPosition(pos)
//    }
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Another interface callback
//   }


