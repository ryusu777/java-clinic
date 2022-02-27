package com.clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This is the connection for the database with the table name "clinic" that
 * connects to a mariadb server
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public class ClinicConnection {
    private static Connection conn;

    public static void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost/clinic", "root", null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Excecute <code>sqlQuery</code> to the clinic database
     * @param sqlQuery
     * @return <code>ResultSet</code> of the resulting query
     */
    public static ResultSet query(String sqlQuery) throws SQLException {
        Statement statement = conn.createStatement();
        return statement.executeQuery(sqlQuery);
    }

    /**
     * Excecute <code>sqlQuery</code> to the clinic database
     * @param sqlQuery
     * @return <code>boolean</code> representing successfully excecuted or not
     */
    public static boolean excecute(String sqlQuery) throws SQLException {
        Statement statement = conn.createStatement();
        return statement.execute(sqlQuery);
    }
}
