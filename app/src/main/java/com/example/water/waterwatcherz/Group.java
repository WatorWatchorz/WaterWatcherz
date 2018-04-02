package com.example.water.waterwatcherz;

import java.util.ArrayList;

/**
<<<<<<< Updated upstream
 * Creates a unique group. Contains User objects, specifies the owner of a group,
 * and has a unique group code
 * Created by eesha on 3/28/2018.
 */

public class Group
{
    //Data
    private User owner;
    private int groupCode;
    private ArrayList<User> users;

    //Constructor
    public Group(User owner, int groupCode, ArrayList users)
    {
        owner = null;
        groupCode = -1;
        users = null;
    }
    public Group()
    {
        owner = null;
        groupCode = -1;
        users = null;
    }

    //Methods
    public void addUser(User m)
    {
        users.add(m);
    }
    public void setOwner(User o)
    {
        owner = o;
    }
    public void setGroupCode(int g)
    {
        groupCode = g;
    }
    public ArrayList<User> getUsers()
    {
        return users;
    }
    public User getOwner()
    {
        return owner;
    }
    public int getGroupCode()
    {
        return groupCode;
    }
}
