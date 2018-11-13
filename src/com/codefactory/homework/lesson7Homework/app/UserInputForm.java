package com.codefactory.homework.lesson7Homework.app;

import com.codefactory.homework.lesson7Homework.dao.UserDaoIntf;
import com.codefactory.homework.lesson7Homework.dao.impl.CSVUserDaoImpl;
import com.codefactory.homework.lesson7Homework.dao.impl.InmemoryUserDaoImpl;
import com.codefactory.homework.lesson7Homework.domain.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class UserInputForm {
    private static UserDaoIntf userDao;

    public static void showUserInputForm() {
        Stage window = new Stage();
        window.setTitle("Add New User");
        window.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setPadding(new Insets(25, 25, 25 ,25));

        //  Top Label
        Text sceneTitle = new Text("New User");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        HBox sceneTitleBox = new HBox(sceneTitle);
        sceneTitleBox.setAlignment(Pos.CENTER);
        grid.add(sceneTitleBox, 0, 0, 2, 1);

        // User ID Row
        Label userIdLabel = new Label("ID");
        TextField userIdTextField = new TextField();
        userIdTextField.setPromptText("1");

        // User First Name Row
        Label userFirstNameLabel = new Label("First Name");
        TextField userFirstNameTextField = new TextField();
        userFirstNameTextField.setPromptText("John");

        // User Last Name Row
        Label userLastNameLabel = new Label("Last Name");
        TextField userLastNameTextField = new TextField();
        userLastNameTextField.setPromptText("Doe");

        grid.add(userIdLabel, 0, 1);
        grid.add(userIdTextField, 1, 1);
        grid.add(userFirstNameLabel, 0, 2);
        grid.add(userFirstNameTextField, 1, 2);
        grid.add(userLastNameLabel, 0, 3);
        grid.add(userLastNameTextField, 1, 3);

        // Saving Method Radio Buttons
        Text saveMethod = new Text("Save as:");
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton inmemoryRadioButton = new RadioButton("Inmemory");
        RadioButton CSVRadioButton = new RadioButton("CSV File");

        inmemoryRadioButton.setToggleGroup(toggleGroup);
        inmemoryRadioButton.setSelected(true);
        CSVRadioButton.setToggleGroup(toggleGroup);

        VBox saveAsBox = new VBox(10);
        saveAsBox.setAlignment(Pos.CENTER);
        saveAsBox.setPadding(new Insets(5, 0, 5, 0));
        HBox toggleGroupBox = new HBox(50);
        toggleGroupBox.setAlignment(Pos.CENTER);

        toggleGroupBox.getChildren().addAll(inmemoryRadioButton, CSVRadioButton);
        saveAsBox.getChildren().addAll(saveMethod, toggleGroupBox);

        grid.add(saveAsBox, 0, 4, 2, 1);

        Button addBtn = new Button("Add");
        HBox addBtnBox = new HBox( addBtn);
        addBtnBox.setAlignment(Pos.CENTER);

        addBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            try {
                switch (selectedRadioButton.getText()) {
                    case "Inmemory": {
                        userDao = new InmemoryUserDaoImpl();
                        final long userId = Long.parseLong(userIdTextField.getText().trim());
                        final String userFirstName = userFirstNameTextField.getText().trim();
                        final String userLastName = userLastNameTextField.getText().trim() ;

                        userDao.save(new User(userId, userFirstName, userLastName));

                        userDao.findAll().stream().forEach(System.out::println);
                        break;
                    }

                    case "CSV File": {
                        String fileName = JOptionPane.showInputDialog("Enter file name:").trim();
                        userDao = (fileName.isEmpty()) ? new CSVUserDaoImpl() : new CSVUserDaoImpl(fileName);
                        final long userId = Long.parseLong(userIdTextField.getText().trim());
                        final String userFirstName = userFirstNameTextField.getText().trim();
                        final String userLastName = userLastNameTextField.getText().trim();

                        userDao.save(new User(userId, userFirstName, userLastName));
                        break;
                    }
                }
            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }

            window.close();
        });

        grid.add(addBtnBox, 0, 5, 2, 1);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();
    }
}
