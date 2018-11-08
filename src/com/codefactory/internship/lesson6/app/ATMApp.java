package com.codefactory.internship.lesson6.app;

import com.codefactory.internship.lesson6.utils.PinUtils;

import javax.swing.*;

public class ATMApp {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to ATM!");

        String userInput = JOptionPane.showInputDialog("Enter your PIN:");
        final int PIN = Integer.parseInt(userInput);
        boolean result = PinUtils.validatePin(PIN);

        JOptionPane.showMessageDialog(null, (result) ? "Correct PIN" : "Wrong PIN");
    }
}
