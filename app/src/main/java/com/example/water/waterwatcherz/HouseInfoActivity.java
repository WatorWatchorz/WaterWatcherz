package com.example.water.waterwatcherz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;

/**
 * Created by krish on 4/10/2018.
 */

public class HouseInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_info);
        Bundle bundle = getIntent().getExtras();


        Spinner townSpinner = findViewById(R.id.townDropDown);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.towns_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        townSpinner.setAdapter(adapter2);
        townSpinner.setOnItemSelectedListener(this);
    }

//  public void storeInformation() {
// EditText numPplEdit = findViewById(R.id.NumPplEDT);
//        String numPplStr = numPplEdit.getText().toString();
//        if (!(numPplStr.isEmpty())) {
//            int numPpl = Integer.parseInt(numPplStr);
//        }
//    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
