package ua.lviv.iot.model;

import ua.lviv.iot.controller.connection.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Order {
    private static final String FIND_ALL = "SELECT * FROM `order`";
    private static final String FIND_BY_ID = "SELECT * FROM `order` WHERE id=?";
    private static final String CREATE = "INSERT INTO `order` (from_department_id, to_department_id" +
            ", from_operator_id, to_operator_id, from_courier_id, to_courier_id, from_client_id, to_client_id" +
            ", delivery_price, product_price, weight, sending_date, approximate_arrival_date, fixed_arrival_date)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `order` SET " +
            "from_department_id=?, to_department_id=?, from_operator_id=?, to_operator_id=?, from_courier_id=?" +
            ", to_courier_id=?, from_client_id=?, to_client_id=?, delivery_price=?, product_price=?, weight=?" +
            ", sending_date=?, approximate_arrival_date=?, fixed_arrival_date=?" +
            " WHERE id=?";
    private static final String DELETE = "DELETE FROM `order` WHERE id=?";

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

    public void create(Integer fromDepartmentId, Integer toDepartmentId, Integer fromOperatorId,
                       Integer toOperatorId, Integer fromCourierId, Integer toCourierId,
                       Integer fromClientId, Integer toClientId, BigDecimal deliveryPrice,
                       BigDecimal productPrice, Integer weight, Date sendingDate,
                       Date approximateArrivalDate, Date fixedArrivalDate) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, fromDepartmentId);
            ps.setInt(2, toDepartmentId);
            ps.setInt(3, fromOperatorId);
            ps.setInt(4, toOperatorId);
            if (fromCourierId != null) {
                ps.setInt(5, fromCourierId);
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            if (toCourierId != null) {
                ps.setInt(6, toCourierId);
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            ps.setInt(7, fromClientId);
            ps.setInt(8, toClientId);
            ps.setBigDecimal(9, deliveryPrice);
            if (productPrice != null) {
                ps.setBigDecimal(10, productPrice);
            } else {
                ps.setNull(10, Types.DECIMAL);
            }
            ps.setInt(11, weight);
            ps.setDate(12, sendingDate);
            ps.setDate(13, approximateArrivalDate);
            if (fixedArrivalDate != null) {
                ps.setDate(14, fixedArrivalDate);
            } else {
                ps.setNull(14, Types.DATE);
            }

            ps.executeUpdate();
        }
    }

    public void update(Integer id, Integer fromDepartmentId, Integer toDepartmentId, Integer fromOperatorId,
                       Integer toOperatorId, Integer fromCourierId, Integer toCourierId,
                       Integer fromClientId, Integer toClientId, BigDecimal deliveryPrice,
                       BigDecimal productPrice, Integer weight, Date sendingDate,
                       Date approximateArrivalDate, Date fixedArrivalDate) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, fromDepartmentId);
            ps.setInt(2, toDepartmentId);
            ps.setInt(3, fromOperatorId);
            ps.setInt(4, toOperatorId);
            if (fromCourierId != null) {
                ps.setInt(5, fromCourierId);
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            if (toCourierId != null) {
                ps.setInt(6, toCourierId);
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            ps.setInt(7, fromClientId);
            ps.setInt(8, toClientId);
            ps.setBigDecimal(9, deliveryPrice);
            if (productPrice != null) {
                ps.setBigDecimal(10, productPrice);
            } else {
                ps.setNull(10, Types.DECIMAL);
            }
            ps.setInt(11, weight);
            ps.setDate(12, sendingDate);
            ps.setDate(13, approximateArrivalDate);
            if (fixedArrivalDate != null) {
                ps.setDate(14, fixedArrivalDate);
            } else {
                ps.setNull(14, Types.DATE);
            }
            ps.setInt(15, id);

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
            System.out.print(", from_department_id: " + resultSet.getInt("from_department_id"));
            System.out.print(", to_department_id: " + resultSet.getInt("to_department_id"));
            System.out.print(", from_operator_id: " + resultSet.getInt("from_operator_id"));
            System.out.print(", to_operator_id: " + resultSet.getInt("to_operator_id"));
            System.out.print(", from_courier_id: " +
                    (resultSet.getObject("from_courier_id") != null ? resultSet.getInt("from_courier_id") : null));
            System.out.print(", to_courier_id: " +
                    (resultSet.getObject("to_courier_id") != null ? resultSet.getInt("to_courier_id") : null));
            System.out.print(", from_client_id: " + resultSet.getInt("from_client_id"));
            System.out.print(", to_client_id: " + resultSet.getInt("to_client_id"));
            System.out.print(", delivery_price: " + resultSet.getBigDecimal("delivery_price"));
            System.out.print(", product_price: " + resultSet.getBigDecimal("product_price"));
            System.out.print(", weight: " + resultSet.getInt("weight"));
            System.out.print(", sending_date: " + resultSet.getDate("sending_date"));
            System.out.print(", approximate_arrival_date: " + resultSet.getDate("approximate_arrival_date"));
            System.out.print(", fixed_arrival_date: " + resultSet.getDate("fixed_arrival_date"));
            System.out.println("}");
        }
    }
}
