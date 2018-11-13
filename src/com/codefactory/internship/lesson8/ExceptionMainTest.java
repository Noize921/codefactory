package com.codefactory.internship.lesson8;

import com.codefactory.internship.lesson8.dto.UserDataDto;
import com.codefactory.internship.lesson8.execptions.UserNotFoundException;
import com.codefactory.internship.lesson8.service.UserService;

import javax.swing.*;

public class ExceptionMainTest {
    public static void main(String[] args) {
        UserService userService = new UserService();

        String userInput = JOptionPane.showInputDialog("Enter user ID:");
        long userId = Long.parseLong(userInput);

        try {
            UserDataDto userData = userService.getFullData(userId);
            displayUserData(userData);
        } catch (UserNotFoundException e) {
            showErrorMessage(e.getMessage());
        } catch (Exception e) {
            String errorMessage = "An unexpected exception occured";
            showErrorMessage(errorMessage);
        }
    }

    private static void showErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static void displayUserData(UserDataDto userData) {
        JOptionPane.showMessageDialog(null, userData.toString(), "User Data", JOptionPane.INFORMATION_MESSAGE);
    }
}
