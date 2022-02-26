package com.clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClinicConnection {
    private static Connection conn;

    public static void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost/clinic", "root", null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet query(String sqlQuery) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
