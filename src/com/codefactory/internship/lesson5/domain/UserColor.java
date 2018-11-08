package com.codefactory.internship.lesson5.domain;

public class UserColor {
    private String colorCode;
    private String colorName;

    public UserColor(String colorCode, String colorName) {
        this.colorCode = colorCode;
        this.colorName = colorName;
    }

    @Override
    public String toString() {
        return colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
