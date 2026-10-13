package com.employeemanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
            System.getenv().getOrDefault("DB_URL", "jdbc:mysql://127.0.0.1:3306/company");
    private static final String USERNAME =
            System.getenv().getOrDefault("DB_USERNAME", "root");
    private static final String PASSWORD = java.util.Objects.requireNonNull(
            System.getenv("DB_PASSWORD"), "Set the DB_PASSWORD environment variable");

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
