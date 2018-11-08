package com.codefactory.internship.lesson5.domain;

import javax.swing.*;

public class UserInputProgram {
    public static void main(String[] args) {
        String color;
        int iterations;

        UserColor[] options = new UserColor[] {
                new UserColor("\u001B[31m,", "Red"),
                new UserColor("\u001B[32m", "Green")
        };

        Object userInput = JOptionPane.showInputDialog(null, "Select color...", "Color selector", JOptionPane.INFORMATION_MESSAGE, null, options, options[1]).toString();
        UserColor selectedOption = (UserColor) userInput;
        color = selectedOption.getColorCode();

        String numberInput = JOptionPane.showInputDialog("Insert number of iterations");
        iterations = Integer.parseInt(numberInput);

        Settings settings = SettingUtil.storeUserSettings(color,iterations);

        //UtilMethods.sayHello(settings);

        String text = JOptionPane.showInputDialog("Please insert your text");
        UtilMethods.sayHello(settings,text);
    }
}
