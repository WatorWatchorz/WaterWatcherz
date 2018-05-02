package com.example.water.waterwatcherz;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class DatabaseTest extends AppCompatActivity {
    List <User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Database")
                .allowMainThreadQueries().build();

        list = db.userDao().getAllUsers();
        User jim = new User();
        jim.setId(1);
        jim.setName("Jim");
        User bob = new User();
        bob.setId(2);
        bob.setName("Bob");
        list.add(jim);
        list.add(bob);
        ArrayAdapter<User> myAdapter = new ArrayAdapter<User>(this,android.R.layout.simple_list_item_1, list);
        final ListView myListView = (ListView) findViewById(R.id.simple_listview);
        myListView.setAdapter(myAdapter);
    }
}
