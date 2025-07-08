package com.example.groupproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize your primary stage and load your initial FXML (login.fxml)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Coffee Management Store");
        primaryStage.setWidth(500);
        primaryStage.setHeight(380);
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(380);
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(380);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}