package ua.lviv.iot.model;

import ua.lviv.iot.controller.connection.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Courier {
    private static final String FIND_ALL = "SELECT * FROM `courier`";
    private static final String FIND_BY_ID = "SELECT * FROM `courier` WHERE id=?";
    private static final String CREATE =
            "INSERT INTO `courier` (department_id, name, surname, address, phone, birthday)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "UPDATE `courier` SET department_id=?, name=?, surname=?, address=?, phone=?, birthday=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `courier` WHERE id=?";

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

    public void create(Integer departmentId, String name, String surname, String address,
                       BigDecimal phone, Date birthday) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, departmentId);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, address);
            ps.setBigDecimal(5, phone);
            ps.setDate(6, birthday);

            ps.executeUpdate();
        }
    }

    public void update(Integer id, Integer departmentId, String name, String surname, String address,
                       BigDecimal phone, Date birthday) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, departmentId);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, address);
            ps.setBigDecimal(5, phone);
            ps.setDate(6, birthday);
            ps.setInt(7, id);

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
            System.out.print(", department_id: " + resultSet.getInt("department_id"));
            System.out.print(", name: " + resultSet.getString("name"));
            System.out.print(", surname: " + resultSet.getString("surname"));
            System.out.print(", address: " + resultSet.getString("address"));
            System.out.print(", phone: " + resultSet.getBigDecimal("phone"));
            System.out.print(", birthday: " + resultSet.getDate("birthday"));
            System.out.println("}");
        }
    }
}
