package com.example.listviewapp.model;

public class ItemContent {
    private String description;
    private String countryName;
    private int image;

    public ItemContent(String description, String countryName, int image) {
        this.description = description;
        this.countryName = countryName;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
