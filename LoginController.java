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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class LoginController {
    public void goTo(String whereTo, Node uiElement) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(whereTo));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) uiElement.getScene().getWindow();
            stage.setMaximized(true);
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

        boolean correctLogin = false;

        for (int i = 0; i < usernames.length; i++){
            if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i]))
                correctLogin = true;
        }

        if (correctLogin)
            goToOverview();

        else
            errorMessage.setOpacity(1);

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
    public void goToInventory(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = load(Objects.requireNonNull(getClass().getResource("FXMLDocument.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Alice Stock Management");
            stage.getIcons().add(new Image("/mart/shop.png"));
            scene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }


}
