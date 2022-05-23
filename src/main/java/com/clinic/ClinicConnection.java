package com.clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/clinic", "root", "RoseCat21*");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to connect to database, exiting...");
            System.exit(1);
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
     * @return <code>Boolean</code> representing successfully excecuted or not
     */
    public static Boolean execute(String sqlQuery) throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute(sqlQuery);
        return statement.getUpdateCount() > 0;
    }

    /**
     * Excecute <code>sqlQuery</code> to the clinic database
     * @param sqlQuery
     * @return <code>Integer</code> representing the created key
     */
    public static Integer executeInsert(String sqlQuery) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        statement.execute();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next())
            return generatedKeys.getInt(1);
        return 0;
    }
}
