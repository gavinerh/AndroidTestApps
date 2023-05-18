package com.example.viewpager.model;

import com.example.viewpager.R;

public enum ModelCourse {

    RED (R.string.red, R.layout.view_red),
    BLUE (R.string.blue, R.layout.view_blue),
    GREEN (R.string.green, R.layout.view_green);

    private int titleID;
    private int layoutID;

    ModelCourse(int titleID, int layoutID) {
        this.titleID = titleID;
        this.layoutID = layoutID;
    }

    public int getTitleID() {
        return titleID;
    }

    public int getLayoutID() {
        return layoutID;
    }
}
