package com.example.groupproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import static javafx.fxml.FXMLLoader.load;

public class LoginController {
    public void goTo(String whereTo, Node uiElement) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + whereTo));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) uiElement.getScene().getWindow();
            
            // Set appropriate window size based on the FXML being loaded
            if (whereTo.equals("overview.fxml")) {
                stage.setWidth(800);
                stage.setHeight(600);
                stage.setMinWidth(800);
                stage.setMinHeight(600);
                stage.setMaxWidth(800);
                stage.setMaxHeight(600);
            } else if (whereTo.equals("invoice.fxml") || whereTo.equals("restock.fxml")) {
                stage.setWidth(500);
                stage.setHeight(350);
                stage.setMinWidth(500);
                stage.setMinHeight(350);
                stage.setMaxWidth(500);
                stage.setMaxHeight(350);
            } else {
                // Default size for other screens
                stage.setWidth(500);
                stage.setHeight(380);
                stage.setMinWidth(500);
                stage.setMinHeight(380);
                stage.setMaxWidth(500);
                stage.setMaxHeight(380);
            }
            
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @FXML
    TextField usernameBox;

    @FXML
    PasswordField passwordBox;

    @FXML
    Text errorMessage;

    String[] usernames = {"Admin", "Tonning", "James", "Manager"};
    String[] passwords = {"Password", "Cheese51", "JamesIsACat", "123"}; // There should probably be some encryption on these, but that's above my pay grade.

    @FXML
    public void logIn(){
        String inputUsername = usernameBox.getText();
        String inputPassword = passwordBox.getText();

        System.out.println("Login attempt - Username: " + inputUsername + ", Password: " + inputPassword);

        boolean correctLogin = false;

        for (int i = 0; i < usernames.length; i++){
            if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i])) {
                correctLogin = true;
                System.out.println("Login successful for user: " + usernames[i]);
                break;
            }
        }

        if (correctLogin) {
            System.out.println("Redirecting to overview...");
            goToOverview();
        } else {
            System.out.println("Login failed - showing error message");
            errorMessage.setOpacity(1);
        }
    }

    @FXML
    Text welcomeMessage;

    String currentScene = "";

    public void goToOverview() {
        goTo("overview.fxml", errorMessage);
        currentScene = "overview";
    }

    public void goToInvoice(){
        goTo("invoice.fxml", welcomeMessage);
        currentScene = "invoice";
    }

    public void goToRestock(){
        goTo("restock.fxml", welcomeMessage);
        currentScene = "restock";
    }

    @FXML
    Text titleRestock, titleInventory, titleInvoice;

    public void backFromInvoice(){
        goTo("overview.fxml", titleInvoice);
    }

    public void backFromRestock(){
        goTo("overview.fxml", titleRestock);
    }

    @FXML
    public void goToInventory(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = load(Objects.requireNonNull(getClass().getResource("/FXMLDocument.fxml")));
            Scene scene = new Scene(root);
            stage.setWidth(1400);
            stage.setHeight(800);
            stage.setMinWidth(1400);
            stage.setMinHeight(800);
            stage.setMaxWidth(1400);
            stage.setMaxHeight(800);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Coffee Stock Management");
            scene.getStylesheets().add(getClass().getResource("/design.css").toExternalForm());
            
            // Position window in center of screen
            stage.setX((javafx.stage.Screen.getPrimary().getVisualBounds().getWidth() - 1400) / 2);
            stage.setY((javafx.stage.Screen.getPrimary().getVisualBounds().getHeight() - 800) / 2);
            
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @FXML
    public void logoutAction(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = load(Objects.requireNonNull(getClass().getResource("/login.fxml")));
            Scene scene = new Scene(root);
            stage.setWidth(500);
            stage.setHeight(380);
            stage.setMinWidth(500);
            stage.setMinHeight(380);
            stage.setMaxWidth(500);
            stage.setMaxHeight(380);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
