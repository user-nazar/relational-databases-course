package ua.lviv.iot.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public interface IController {

    void findAllOrders() throws SQLException;

    void findOrderById(Integer id) throws SQLException;

    void createOrder(Integer fromDepartmentId, Integer toDepartmentId, Integer fromOperatorId,
                     Integer toOperatorId, Integer fromCourierId, Integer toCourierId,
                     Integer fromClientId, Integer toClientId, BigDecimal deliveryPrice,
                     BigDecimal productPrice, Integer weight, Date sendingDate,
                     Date approximateArrivalDate, Date fixedArrivalDate) throws SQLException;

    void updateOrder(Integer id, Integer fromDepartmentId, Integer toDepartmentId, Integer fromOperatorId,
                     Integer toOperatorId, Integer fromCourierId, Integer toCourierId,
                     Integer fromClientId, Integer toClientId, BigDecimal deliveryPrice,
                     BigDecimal productPrice, Integer weight, Date sendingDate,
                     Date approximateArrivalDate, Date fixedArrivalDate) throws SQLException;

    void deleteOrder(Integer id) throws SQLException;

    void findAllClients() throws SQLException;

    void findClientById(Integer id) throws SQLException;

    void createClient(String name, String surname, BigDecimal phone, String address) throws SQLException;

    void updateClient(Integer id, String name, String surname, BigDecimal phone, String address) throws SQLException;

    void deleteClient(Integer id) throws SQLException;

    void findAllAccounts() throws SQLException;

    void findAccountById(Integer id) throws SQLException;

    void createAccount(Integer id, String username, String password, String email) throws SQLException;

    void updateAccount(Integer id, String username, String password, String email) throws SQLException;

    void deleteAccount(Integer id) throws SQLException;

    void findAllCities() throws SQLException;

    void findCityById(String name) throws SQLException;

    void createCity(String name) throws SQLException;

    void updateCity(String name, String newName) throws SQLException;

    void deleteCity(String name) throws SQLException;

    void findAllCouriers() throws SQLException;

    void findCourierById(Integer id) throws SQLException;

    void createCourier(Integer departmentId, String name, String surname, String address,
                       BigDecimal phone, Date birthday) throws SQLException;

    void updateCourier(Integer id, Integer departmentId, String name, String surname, String address,
                       BigDecimal phone, Date birthday) throws SQLException;

    void deleteCourier(Integer id) throws SQLException;

    void findAllOperators() throws SQLException;

    void findOperatorById(Integer id) throws SQLException;

    void createOperator(Integer departmentId, String name, String surname, String address,
                       BigDecimal phone, Date birthday) throws SQLException;

    void updateOperator(Integer id, Integer departmentId, String name, String surname, String address,
                       BigDecimal phone, Date birthday) throws SQLException;

    void deleteOperator(Integer id) throws SQLException;

    void findAllDepartments() throws SQLException;

    void findDepartmentById(Integer id) throws SQLException;

    void createDepartment(String departmentTypeSize, String cityName, Integer number, String address)
            throws SQLException;

    void updateDepartment(Integer id, String departmentTypeSize, String cityName, Integer number, String address)
            throws SQLException;

    void deleteDepartment(Integer id) throws SQLException;

    void findAllDepartmentTypes() throws SQLException;

    void findDepartmentTypeById(String size) throws SQLException;

    void createDepartmentType(String size, Integer maxWeight) throws SQLException;

    void updateDepartmentType(String size, Integer maxWeight, String newSize) throws SQLException;

    void deleteDepartmentType(String size) throws SQLException;
}
