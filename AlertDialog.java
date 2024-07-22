/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AlertDialog {
    public static void display(String title,String message){
        final Stage stage=new Stage();
        stage.setTitle(title);
//        stage.setMinWidth(500);
//        stage.setMaxHeight(250);
        
        Label label=new Label();
        label.setText(message);
        Button button=new Button("Ok");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               stage.close();
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        VBox box=new VBox();
        
        box.getChildren().addAll(label,button);
        box.setAlignment(Pos.CENTER);
        
        Scene scene=new Scene(box,280,100);
       
        stage.setScene(scene);
        stage.showAndWait();
       
    }
}
