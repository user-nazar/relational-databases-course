package ua.lviv.iot.model;

import ua.lviv.iot.controller.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
    private static final String FIND_ALL = "SELECT * FROM `account`";
    private static final String FIND_BY_ID = "SELECT * FROM `account` WHERE client_id=?";
    private static final String CREATE = "INSERT INTO `account` (client_id, username, password, email)" +
            " VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `account` SET username=?, password=?, email=? WHERE client_id=?";
    private static final String DELETE = "DELETE FROM `account` WHERE client_id=?";

    public void findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                print(resultSet);
            }
        }
    }

    public void findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                print(resultSet);
            }
        }
    }

    public void create(Integer id, String username, String password, String email) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, String username, String password, String email) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, id);

            ps.executeUpdate();
        }
    }

    public void delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{client_id: " + resultSet.getInt("client_id"));
            System.out.print(", username: " + resultSet.getString("username"));
            System.out.print(", password: " + resultSet.getString("password"));
            System.out.print(", email: " + resultSet.getString("email"));
            System.out.println("}");
        }
    }
}
