package com.codefactory.homework.lesson7Homework.app;

import com.codefactory.homework.lesson7Homework.dao.UserDaoIntf;
import com.codefactory.homework.lesson7Homework.dao.impl.CSVUserDaoImpl;
import com.codefactory.homework.lesson7Homework.dao.impl.InmemoryUserDaoImpl;
import com.codefactory.homework.lesson7Homework.domain.User;
import com.codefactory.homework.lesson7Homework.util.CSVFileUtil;
import com.sun.istack.internal.NotNull;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserDaoIntfApp extends Application {
    private static UserDaoIntf userDao;
    private Scene mainScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Main menu");

        BorderPane borderPane = new BorderPane();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(20, 20, 20, 20));

        VBox buttonGroup = new VBox(10);
        buttonGroup.setAlignment(Pos.CENTER);
        buttonGroup.setPadding(new Insets(0, 0, 20, 0));

        Text mainLabel = new Text("User Database");
        mainLabel.setStyle("-fx-font-size: 20px; -fx-font-family: Cambria; -fx-font-weight: bold;");

        Button addUserBtn = addButton("Add User");
        Button viewInmemoryUsersBtn = addButton("Show Inmemory Users");
        Button viewCSVUsersUsersBtn = addButton("Show Users From CSV File");

        addUserBtn.setOnAction(e -> {
            UserInputForm.showUserInputForm();
        });

        viewInmemoryUsersBtn.setOnAction(e -> {
            userDao = new InmemoryUserDaoImpl();

            printToConsole(userDao.findAll());
        });

        viewCSVUsersUsersBtn.setOnAction(e -> {
            String fileName = null;

            try {
                fileName = JOptionPane.showInputDialog("Enter file name:").trim();
            } catch (NullPointerException exc) {
                System.err.println(exc.getMessage());
            }

            if (CSVFileUtil.fileExists(fileName)) {
                userDao = new CSVUserDaoImpl(fileName);

                UserDisplayWindow.displayUsersInWindow(userDao.findAll());
            } else if (fileName == null) {
                userDao = new CSVUserDaoImpl();

                UserDisplayWindow.displayUsersInWindow(userDao.findAll());
            } else {
                JOptionPane.showMessageDialog(null, "File doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        hBox.getChildren().add(mainLabel);
        buttonGroup.getChildren().addAll(addUserBtn, viewInmemoryUsersBtn, viewCSVUsersUsersBtn);

        borderPane.setTop(hBox);
        borderPane.setCenter(buttonGroup);

        mainScene = new Scene(borderPane, 300, 230, Color.LIGHTGRAY);
        window.setScene(mainScene);
        window.show();
    }

    @NotNull
    private void printToConsole(List<User> users) {
        if (users.size() > 0) {
            for (User user : users) {
                System.out.println(String.format("ID: %d\n" +
                        "First Name: %s\n" +
                        "Last Name: %s", user.getId(), user.getFirstName(), user.getLastName()));
            }
        } else {
            System.err.println("No users to display!");
        }
    }

    private Button addButton(String str) {
        Button button = new Button(str);
        button.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#f2f2f2, #d6d6d6),\n" +
                "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
                "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
                "    -fx-background-radius: 8,7,6;\n" +
                "    -fx-background-insets: 0,1,2;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );" +
                "    -fx-font-size: 14px;" +
                "    -fx-cursor: hand;");

        return button;
    }
}
