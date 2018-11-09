package com.codefactory.internship.lesson6.utils;

public class BankAccountUtil {
    private static final int TOTAL_AMOUNT = 1000;

    public static boolean hasSufficentFunds(int userAmount) {
        return userAmount <= TOTAL_AMOUNT;
    }
}
