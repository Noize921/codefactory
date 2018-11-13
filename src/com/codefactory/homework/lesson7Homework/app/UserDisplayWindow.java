package com.codefactory.homework.lesson7Homework.app;

import com.codefactory.homework.lesson7Homework.domain.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class UserDisplayWindow {
    public static void displayUsersInWindow(List<User> users) {
        Stage window = new Stage();

        window.setTitle("Users List");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        window.setMinHeight(370);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setHgap(35);
        grid.setPadding(new Insets(15, 45, 15, 35));


        final Label idColLabel = new Label("ID");
        idColLabel.setStyle("-fx-font-weight: bold; -fx-font-family: arial; -fx-font-size: 14px");
        final Label firstNameColLabel = new Label("First Name");
        firstNameColLabel.setStyle("-fx-font-weight: bold; -fx-font-family: arial; -fx-font-size: 14px");
        final Label lastNameColLabel = new Label("Last Name");
        lastNameColLabel.setStyle("-fx-font-weight: bold; -fx-font-family: arial; -fx-font-size: 14px");

        grid.add(idColLabel, 0, 0);
        grid.add(firstNameColLabel, 1, 0);
        grid.add(lastNameColLabel, 2, 0);

        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);

            grid.add(addText(String.valueOf(currentUser.getId())), 0, i + 1);
            grid.add(addText(currentUser.getFirstName()), 1, i + 1);
            grid.add(addText(currentUser.getLastName()), 2, i + 1);
        }


        ScrollPane scrollBar = new ScrollPane(grid);
        scrollBar.setPrefSize(300, 370);
        scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Scene scene = new Scene(scrollBar);
        window.setScene(scene);
        window.show();
    }

    private static Text addText(String str) {
        Text text = new Text(str);
        text.setStyle("-fx-font-family: Arial; -fx-font-size: 12px;");

        return text;
    }
}
