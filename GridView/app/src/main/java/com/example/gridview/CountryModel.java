package com.example.gridview;

public class CountryModel {
    private int image;
    private String courseName;

    public CountryModel(int image, String courseName) {
        this.image = image;
        this.courseName = courseName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
