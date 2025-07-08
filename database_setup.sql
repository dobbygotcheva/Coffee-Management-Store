-- Coffee Management Store Database Setup
-- Run this script in MySQL to create the database and tables

-- Create database
CREATE DATABASE IF NOT EXISTS coffee_store_db;
USE coffee_store_db;

-- Create stock table
CREATE TABLE IF NOT EXISTS `stock` (
    `product_id` VARCHAR(50) PRIMARY KEY,
    `p_name` VARCHAR(100) NOT NULL,
    `price` DECIMAL(10,2) NOT NULL,
    `quantity` INT NOT NULL DEFAULT 0
);

-- Insert sample coffee products
INSERT INTO `stock` (`product_id`, `p_name`, `price`, `quantity`) VALUES
('COF001', 'Espresso', 3.50, 100),
('COF002', 'Cappuccino', 4.50, 80),
('COF003', 'Latte', 4.00, 90),
('COF004', 'Americano', 3.00, 75),
('COF005', 'Mocha', 5.00, 60),
('COF006', 'Macchiato', 3.75, 70),
('COF007', 'Flat White', 4.25, 65),
('COF008', 'Cold Brew', 4.75, 50);

-- Create users table for authentication (optional enhancement)
CREATE TABLE IF NOT EXISTS `users` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `role` VARCHAR(20) DEFAULT 'user'
);

-- Insert sample users (passwords should be hashed in production)
INSERT INTO `users` (`username`, `password`, `role`) VALUES
('Admin', 'Password', 'admin'),
('Tonning', 'Cheese51', 'manager'),
('James', 'JamesIsACat', 'user'),
('Manager', '123', 'manager'); 