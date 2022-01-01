package ua.lviv.iot.model;

import ua.lviv.iot.controller.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
    private static final String FIND_ALL = "SELECT * FROM `department`";
    private static final String FIND_BY_ID = "SELECT * FROM `department` WHERE id=?";
    private static final String CREATE = "INSERT INTO `department` (department_type_size, city_name, number, address)" +
            " VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `department` SET " +
            "department_type_size=?, city_name=?, number=?, address=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `department` WHERE id=?";

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

    public void create(String departmentTypeSize, String cityName, Integer number, String address)
            throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, departmentTypeSize);
            ps.setString(2, cityName);
            ps.setInt(3, number);
            ps.setString(4, address);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, String departmentTypeSize, String cityName, Integer number, String address)
            throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, departmentTypeSize);
            ps.setString(2, cityName);
            ps.setInt(3, number);
            ps.setString(4, address);
            ps.setInt(5, id);

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
            System.out.print("{id: " + resultSet.getInt("id"));
            System.out.print(", department_type_size: " + resultSet.getString("department_type_size"));
            System.out.print(", city_name: " + resultSet.getString("city_name"));
            System.out.print(", number: " + resultSet.getInt("number"));
            System.out.print(", address: " + resultSet.getString("address"));
            System.out.println("}");
        }
    }
}
