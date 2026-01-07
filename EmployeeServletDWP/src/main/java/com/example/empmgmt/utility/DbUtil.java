
package com.example.empmgmt.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    // Update these values as per your database configuration
    private static final String URL = "jdbc:mysql://localhost:3306/empmanagement_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@39";

    // Returns a new Connection. Caller must close it after use.
    public static Connection getConnection() throws SQLException {
        // Defensive driver registration (helps diagnose if JAR is missing)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found. "
                 + "Place mysql-connector-j-<version>.jar in WEB-INF/lib.", e);
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

