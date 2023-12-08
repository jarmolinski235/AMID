package com.example.sprakoformularz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SprawkoFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personal Data Form");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label firstNameLabel = new Label("Imię:");
        GridPane.setConstraints(firstNameLabel, 0, 0);

        TextField firstNameField = new TextField();
        GridPane.setConstraints(firstNameField, 1, 0);

        Label lastNameLabel = new Label("Nazwisko:");
        GridPane.setConstraints(lastNameLabel, 0, 1);

        TextField lastNameField = new TextField();
        GridPane.setConstraints(lastNameField, 1, 1);

        Label addressLabel = new Label("Adres:");
        GridPane.setConstraints(addressLabel, 0, 2);

        TextField addressField = new TextField();
        GridPane.setConstraints(addressField, 1, 2);

        Label cityLabel = new Label("Miejscowość:");
        GridPane.setConstraints(cityLabel, 0, 3);

        TextField cityField = new TextField();
        GridPane.setConstraints(cityField, 1, 3);

        Label phoneLabel = new Label("Telefon:");
        GridPane.setConstraints(phoneLabel, 0, 4);

        TextField phoneField = new TextField();
        GridPane.setConstraints(phoneField, 1, 4);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 5);

        TextField emailField = new TextField();
        GridPane.setConstraints(emailField, 1, 5);

        Button submitButton = new Button("Zatwierdź");
        GridPane.setConstraints(submitButton, 0, 6);
        GridPane.setColumnSpan(submitButton, 2); // Rozciągnij przycisk na obie kolumny

        grid.getChildren().addAll(
                firstNameLabel, firstNameField,
                lastNameLabel, lastNameField,
                addressLabel, addressField,
                cityLabel, cityField,
                phoneLabel, phoneField,
                emailLabel, emailField,
                submitButton);

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
