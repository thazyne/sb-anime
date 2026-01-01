-- Create database if not exists
CREATE DATABASE IF NOT EXISTS anime_db;

-- Use the database
USE anime_db;

-- Create anime table
CREATE TABLE IF NOT EXISTS anime (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    judul VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL
);
