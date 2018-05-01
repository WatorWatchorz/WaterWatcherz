package com.example.water.waterwatcherz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;

/**
 * Created by krish on 4/10/2018.
 */

public class HouseInfoActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_info);
    }
   /* public void storeInformation() {
        Spinner townSpinner = findViewById(R.id.townDropDown);
        EditText numPplEdit = findViewById(R.id.NumPplEDT);
        String numPplStr = numPplEdit.getText().toString();
        if (!(numPplStr.isEmpty())) {
            int numPpl = Integer.parseInt(numPplStr);
        }
    }*/
}
