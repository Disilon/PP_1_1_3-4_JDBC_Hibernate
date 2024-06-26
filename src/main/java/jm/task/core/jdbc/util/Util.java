package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/pp";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Connected to database");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close() {
        try {
            conn.close();
//            System.out.println("Connection closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
