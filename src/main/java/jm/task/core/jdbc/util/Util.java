package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Util {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/pp";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    private static Connection conn = null;
    private static final Logger logger = Logger.getLogger("Util");

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            log(e);
        }
        return conn;
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            log(e);
        }
    }
    public static void log(Exception e) {
        logger.warning(e.getMessage());
    }
}
