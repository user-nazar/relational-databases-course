package ua.lviv.iot.model;

import ua.lviv.iot.controller.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentType {
    private static final String FIND_ALL = "SELECT * FROM `department_type`";
    private static final String FIND_BY_ID = "SELECT * FROM `department_type` WHERE size=?";
    private static final String CREATE = "INSERT INTO `department_type` (size, max_weight) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE `department_type` SET size=?, max_weight=? WHERE size=?";
    private static final String DELETE = "DELETE FROM `department_type` WHERE size=?";

    public void findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                print(resultSet);
            }
        }
    }

    public void findById(String size) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1, size);
            try (ResultSet resultSet = ps.executeQuery()) {
                print(resultSet);
            }
        }
    }

    public void create(String size, Integer maxWeight) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, size);
            ps.setInt(2, maxWeight);
            ps.executeUpdate();
        }
    }

    public void update(String size, Integer maxWeight, String newSize) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, newSize);
            ps.setInt(2, maxWeight);
            ps.setString(3, size);

            ps.executeUpdate();
        }
    }

    public void delete(String size) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setString(1, size);
            ps.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{size: " + resultSet.getString("size"));
            System.out.print(", max_weight: " + resultSet.getInt("max_weight"));
            System.out.println("}");
        }
    }
}
