package com.example.groupproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DbConnection {
    public static Connection dbConnection(){
        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","123581321Dobby");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
