package ua.lviv.iot.model;

import ua.lviv.iot.controller.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class City {
    private static final String FIND_ALL = "SELECT * FROM `city`";
    private static final String FIND_BY_ID = "SELECT * FROM `city` WHERE name=?";
    private static final String CREATE = "INSERT INTO `city` (name) VALUES (?)";
    private static final String UPDATE = "UPDATE `city` SET name=? WHERE name=?";
    private static final String DELETE = "DELETE FROM `city` WHERE name=?";

    public void findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                print(resultSet);
            }
        }
    }

    public void findById(String name) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1, name);
            try (ResultSet resultSet = ps.executeQuery()) {
                print(resultSet);
            }
        }
    }

    public void create(String name) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public void update(String name, String newName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, newName);
            ps.setString(2, name);

            ps.executeUpdate();
        }
    }

    public void delete(String name) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{name: " + resultSet.getString("name"));
            System.out.println("}");
        }
    }
}
