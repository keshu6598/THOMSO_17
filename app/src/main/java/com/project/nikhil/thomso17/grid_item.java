package com.project.nikhil.thomso17;

import android.widget.Button;

/**
 * Created by nikhil on 5/10/17.
 */

public class grid_item {
    int image;
    String Name;
    Class activity;


    public int getImage() {
        return image;
    }

    public String getName() {
        return Name;
    }

    public Class getActivity() {
        return activity;
    }

    public grid_item(int image, String name, Class activity) {

        this.image = image;
        Name = name;
        this.activity = activity;
    }}
