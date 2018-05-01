package com.example.water.waterwatcherz;

import android.arch.persistence.room.Entity;

/**
 * Created by krish on 5/10/2018.
 */

public class User_Simple {

    private int id;
    private String firstname;

    private String lastname;

    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User_Simple(int id, String firstname, String lastname, String email) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }


}
