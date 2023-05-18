package com.example.cardview;

public class CountryModel {
    private String countryName;
    private int countryImage;

    public CountryModel(String countryName, int countryImage) {
        this.countryName = countryName;
        this.countryImage = countryImage;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryImage() {
        return countryImage;
    }

    public void setCountryImage(int countryImage) {
        this.countryImage = countryImage;
    }
}
