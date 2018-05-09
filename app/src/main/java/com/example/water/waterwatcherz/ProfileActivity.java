package com.example.water.waterwatcherz;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class ProfileActivity  extends AppCompatActivity {

    List<User> users;
    private Button taskActivityButton_profile;
    private Button profilebutton_profile;
    private Button utilitybutton_profile;
    private Button confirmbutton_profile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_info);
        Bundle bundle = getIntent().getExtras();

        taskActivityButton_profile = (Button) findViewById(R.id.calendar_houseinfo);
        utilitybutton_profile = (Button) findViewById(R.id.utilitybutton_houseinfo);
        profilebutton_profile = (Button) findViewById(R.id.profile_houseinfo);
        confirmbutton_profile = (Button) findViewById(R.id.confirm);


        taskActivityButton_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openTaskActivity();
            }
        });
        profilebutton_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProfile();
            }
        });
        utilitybutton_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUtiltyInformation();
            }
        });
        confirmbutton_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            EditText hhldsize = findViewById(R.id.NumPplEdit);
            Log.d("TAG","onClick: firstName: " + hhldsize.getText().toString());
            }
        });
    }


    public void openProfile() {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

    public void openTaskActivity() {
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivity(intent);
    }
    public void openUtiltyInformation() {
        Intent intent = new Intent(this,UtilityInformationActivity.class);
        startActivity(intent);
    }

    public void setUserInformation() {
        EditText householdsizetext = (EditText) findViewById(R.id.NumPplEdit);
        if (!householdsizetext.toString().isEmpty()) {
            Integer householdsize = Integer.parseInt(householdsizetext.getText().toString());
            Log.d("HOUSEHOLD SIZE", householdsizetext.toString());
            User user = new User();
            user.setHouseSize(householdsize);
        }
    }

    public void storeInformation() {
        Spinner townSpinner = findViewById(R.id.townDropDown);
        EditText numPplEdit = findViewById(R.id.NumPplEdit);
        String numPplStr = numPplEdit.getText().toString();
        if (!(numPplStr.isEmpty())) {
            int numPpl = Integer.parseInt(numPplStr);
        }
        Context context = getApplicationContext();
        String filename = "UserInformation";
        File file = new File(context.getFilesDir(),filename);
        FileOutputStream outputStream;
        String fileContents = numPplStr;
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"AppDatabase")
                .allowMainThreadQueries()
                .build();

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

    public void displayInformation() {
        /*Context context = getApplicationContext();
        String filename = "UserInformation";
        File directory = context.getFilesDir();
        File file = new File(directory, filename);

        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}

