package com.example.groupproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H2DbConnection {
    // H2 Database configuration - in-memory database
    private static final String DB_URL = "jdbc:h2:mem:coffee_store_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    
    public static Connection dbConnection(){
        Connection conn = null;

        try {
            // Load H2 driver
            Class.forName("org.h2.Driver");
            
            // Create connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            if (conn != null) {
                System.out.println("H2 Database connected successfully!");
                // Initialize the database with tables and sample data
                initializeDatabase(conn);
            }
            
        } catch (ClassNotFoundException e) {
            Logger.getLogger(H2DbConnection.class.getName()).log(Level.SEVERE, "H2 Driver not found", e);
        } catch (SQLException ex) {
            Logger.getLogger(H2DbConnection.class.getName()).log(Level.SEVERE, "Database connection failed", ex);
        }
        return conn;
    }
    
    private static void initializeDatabase(Connection conn) throws SQLException {
        // Create stock table
        String createStockTable = """
            CREATE TABLE IF NOT EXISTS stock (
                product_id VARCHAR(50) PRIMARY KEY,
                p_name VARCHAR(100) NOT NULL,
                price DECIMAL(10,2) NOT NULL,
                quantity INT NOT NULL DEFAULT 0
            )
            """;
        
        // Create users table
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                username VARCHAR(50) UNIQUE NOT NULL,
                password VARCHAR(255) NOT NULL,
                role VARCHAR(20) DEFAULT 'user'
            )
            """;
        
        // Insert sample coffee products
        String insertProducts = """
            INSERT INTO stock (product_id, p_name, price, quantity) VALUES
            ('COF001', 'Espresso', 3.50, 100),
            ('COF002', 'Cappuccino', 4.50, 80),
            ('COF003', 'Latte', 4.00, 90),
            ('COF004', 'Americano', 3.00, 75),
            ('COF005', 'Mocha', 5.00, 60),
            ('COF006', 'Macchiato', 3.75, 70),
            ('COF007', 'Flat White', 4.25, 65),
            ('COF008', 'Cold Brew', 4.75, 50)
            """;
        
        // Insert sample users
        String insertUsers = """
            INSERT INTO users (username, password, role) VALUES
            ('Admin', 'Password', 'admin'),
            ('Tonning', 'Cheese51', 'manager'),
            ('James', 'JamesIsACat', 'user'),
            ('Manager', '123', 'manager')
            """;
        
        try (Statement stmt = conn.createStatement()) {
            // Create tables
            stmt.execute(createStockTable);
            stmt.execute(createUsersTable);
            
            // Insert sample data
            stmt.execute(insertProducts);
            stmt.execute(insertUsers);
            
            System.out.println("Database initialized with sample data!");
        } catch (SQLException e) {
            // Ignore errors if data already exists
            System.out.println("Database already initialized or error occurred: " + e.getMessage());
        }
    }
} 