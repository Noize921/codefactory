package com.codefactory.internship.lesson6.app;

import com.codefactory.internship.lesson6.utils.BankAccountUtil;
import com.codefactory.internship.lesson6.utils.PinUtils;

import javax.swing.*;

public class ATMApp {
    public static void main(String[] args) {
        int numberOfTries = 0;
        boolean isPinCorrect;
        boolean hasSufficentFunds;
        String userInput;
        String[] amountOptions = new String[] {"100", "500", "1000", "2000", "Your option"};
        int amount;

        JOptionPane.showMessageDialog(null, "Welcome to ATM!");



        while (true) {
            userInput = JOptionPane.showInputDialog("Enter your PIN:");
            final int PIN = Integer.parseInt(userInput);
            isPinCorrect = PinUtils.validatePin(PIN);

            if (!isPinCorrect) {
                if (numberOfTries == 2) {
                    showErrorMessage();
                    System.exit(-1);
                }

                numberOfTries++;
                JOptionPane.showMessageDialog(null, "Sorry, wrong PIN!\nTries left: " + (3 - numberOfTries));
            } else {
                break;
            }
        }

        userInput = JOptionPane.showInputDialog(null, "Select amount...", "Amount", JOptionPane.INFORMATION_MESSAGE, null, amountOptions, amountOptions[0]).toString();

        if (userInput.equals("Your option")) {
            userInput = JOptionPane.showInputDialog(null, "Enter amount:", "your amount");
        }

        amount = Integer.parseInt(userInput);

        hasSufficentFunds = BankAccountUtil.hasSufficentFunds(amount);

        if (hasSufficentFunds) {
            JOptionPane.showMessageDialog(null, "Take your money " + amount, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void showErrorMessage() {
        JOptionPane.showMessageDialog(null, "No more attempts left!", "Error message", JOptionPane.ERROR_MESSAGE);
    }
}
