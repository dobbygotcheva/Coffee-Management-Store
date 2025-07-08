package com.example.groupproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    // Database configuration - update these values as needed
    private static final String DB_URL = "jdbc:mysql://localhost:3306/coffee_store_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    
    public static Connection dbConnection(){
        Connection conn = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if (conn != null) {
                System.out.println("Database connected successfully!");
            }
            
        } catch (ClassNotFoundException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "MySQL Driver not found", e);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Database connection failed", ex);
            System.err.println("Database connection failed. Please check:");
            System.err.println("1. MySQL server is running");
            System.err.println("2. Database 'coffee_store_db' exists");
            System.err.println("3. Username and password are correct");
        }
        return conn;
    }
}
