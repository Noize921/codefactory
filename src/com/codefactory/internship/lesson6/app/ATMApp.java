package com.codefactory.internship.lesson6.app;

import com.codefactory.internship.lesson6.utils.PinUtils;

import javax.swing.*;

public class ATMApp {
    public static void main(String[] args) {
        int numberOfTries = 0;

        JOptionPane.showMessageDialog(null, "Welcome to ATM!");

        boolean result = false;

        while (true) {
            String userInput = JOptionPane.showInputDialog("Enter your PIN:");
            final int PIN = Integer.parseInt(userInput);
            result = PinUtils.validatePin(PIN);

            if (result == false) {
                if (numberOfTries == 2) {
                    showErrorMessage();
                    break;
                }

                numberOfTries++;
                JOptionPane.showMessageDialog(null, "Sorry, wrong PIN!\nTries left: " + (3 - numberOfTries));
            }
        }
    }

    private static void showErrorMessage() {
        JOptionPane.showMessageDialog(null, "No more attempts left!", "Error message", JOptionPane.ERROR_MESSAGE);
    }
}
