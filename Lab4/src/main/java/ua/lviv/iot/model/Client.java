package ua.lviv.iot.model;

import ua.lviv.iot.controller.connection.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    private static final String FIND_ALL = "SELECT * FROM `client`";
    private static final String FIND_BY_ID = "SELECT * FROM `client` WHERE id=?";
    private static final String CREATE = "INSERT INTO `client` (name, surname, phone, address) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `client` SET name=?, surname=?, phone=?, address=? WHERE id=?";
    private static final String DELETE = "DELETE FROM `client` WHERE id=?";

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

    public void create(String name, String surname, BigDecimal phone, String address) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setBigDecimal(3, phone);
            if (address != null) {
                ps.setString(4, address);
            } else {
                ps.setString(4, null);
            }

            ps.executeUpdate();
        }
    }

    public void update(Integer id, String name, String surname, BigDecimal phone, String address) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setBigDecimal(3, phone);
            if (address != null) {
                ps.setString(4, address);
            } else {
                ps.setString(4, null);
            }
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
            System.out.print(", name: " + resultSet.getString("name"));
            System.out.print(", surname: " + resultSet.getString("surname"));
            System.out.print(", phone: " + resultSet.getBigDecimal("phone"));
            System.out.print(", address: " +
                    (resultSet.getObject("address") != null ? resultSet.getString("address") : null));
            System.out.println("}");
        }
    }
}
