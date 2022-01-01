package ua.lviv.iot.controller.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/shutka" +
            "?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "ioter";
    private static final String PASSWORD = "iotpassword";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        return connection;
    }
}
