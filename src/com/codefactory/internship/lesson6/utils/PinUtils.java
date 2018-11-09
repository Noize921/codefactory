package com.codefactory.internship.lesson6.utils;

public class PinUtils {
    private final static int PIN = 1234;

    //pin validator method
    public static boolean validatePin(int userPin) {
        return userPin == PIN;
    }
}
