package ua.lviv.iot.controller;

import ua.lviv.iot.model.Account;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Client;
import ua.lviv.iot.model.Courier;
import ua.lviv.iot.model.Department;
import ua.lviv.iot.model.DepartmentType;
import ua.lviv.iot.model.Operator;
import ua.lviv.iot.model.Order;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class Controller implements IController {
    private static Order order;
    private static Client client;
    private static Account account;
    private static City city;
    private static Courier courier;
    private static Operator operator;
    private static Department department;
    private static DepartmentType departmentType;

    public Controller() {
        order = new Order();
        client = new Client();
        account = new Account();
        city = new City();
        courier = new Courier();
        operator = new Operator();
        department = new Department();
        departmentType = new DepartmentType();
    }

    @Override
    public void findAllOrders() throws SQLException {
        order.findAll();
    }

    @Override
    public void findOrderById(Integer id) throws SQLException {
        order.findById(id);
    }

    @Override
    public void createOrder(Integer fromDepartmentId, Integer toDepartmentId, Integer fromOperatorId,
                            Integer toOperatorId, Integer fromCourierId, Integer toCourierId,
                            Integer fromClientId, Integer toClientId, BigDecimal deliveryPrice,
                            BigDecimal productPrice, Integer weight, Date sendingDate,
                            Date approximateArrivalDate, Date fixedArrivalDate) throws SQLException {
        order.create(fromDepartmentId, toDepartmentId, fromOperatorId, toOperatorId, fromCourierId,
                toCourierId, fromClientId, toClientId, deliveryPrice, productPrice, weight, sendingDate,
                approximateArrivalDate, fixedArrivalDate);
    }

    @Override
    public void updateOrder(Integer id, Integer fromDepartmentId, Integer toDepartmentId, Integer fromOperatorId,
                            Integer toOperatorId, Integer fromCourierId, Integer toCourierId,
                            Integer fromClientId, Integer toClientId, BigDecimal deliveryPrice,
                            BigDecimal productPrice, Integer weight, Date sendingDate,
                            Date approximateArrivalDate, Date fixedArrivalDate)
            throws SQLException {
        order.update(id, fromDepartmentId, toDepartmentId, fromOperatorId, toOperatorId, fromCourierId,
                toCourierId, fromClientId, toClientId, deliveryPrice, productPrice, weight, sendingDate,
                approximateArrivalDate, fixedArrivalDate);
    }

    @Override
    public void deleteOrder(Integer id) throws SQLException {
        order.delete(id);
    }

    @Override
    public void findAllClients() throws SQLException {
        client.findAll();
    }

    @Override
    public void findClientById(Integer id) throws SQLException {
        client.findById(id);
    }

    @Override
    public void createClient(String name, String surname, BigDecimal phone, String address) throws SQLException {
        client.create(name, surname, phone, address);
    }

    @Override
    public void updateClient(Integer id, String name, String surname, BigDecimal phone, String address)
            throws SQLException {
        client.update(id, name, surname, phone, address);
    }

    @Override
    public void deleteClient(Integer id) throws SQLException {
        client.delete(id);
    }

    @Override
    public void findAllAccounts() throws SQLException {
        account.findAll();
    }

    @Override
    public void findAccountById(Integer id) throws SQLException {
        account.findById(id);
    }

    @Override
    public void createAccount(Integer id, String username, String password, String email) throws SQLException {
        account.create(id, username, password, email);
    }

    @Override
    public void updateAccount(Integer id, String username, String password, String email) throws SQLException {
        account.update(id, username, password, email);
    }

    @Override
    public void deleteAccount(Integer id) throws SQLException {
        account.delete(id);
    }

    @Override
    public void findAllCities() throws SQLException {
        city.findAll();
    }

    @Override
    public void findCityById(String name) throws SQLException {
        city.findById(name);
    }

    @Override
    public void createCity(String name) throws SQLException {
        city.create(name);
    }

    @Override
    public void updateCity(String name, String newName) throws SQLException {
        city.update(name, newName);
    }

    @Override
    public void deleteCity(String name) throws SQLException {
        city.delete(name);
    }

    @Override
    public void findAllCouriers() throws SQLException {
        courier.findAll();
    }

    @Override
    public void findCourierById(Integer id) throws SQLException {
        courier.findById(id);
    }

    @Override
    public void createCourier(Integer departmentId, String name, String surname, String address,
                              BigDecimal phone, Date birthday) throws SQLException {
        courier.create(departmentId, name, surname, address, phone, birthday);
    }

    @Override
    public void updateCourier(Integer id, Integer departmentId, String name, String surname,
                              String address, BigDecimal phone, Date birthday) throws SQLException {
        courier.update(id, departmentId, name, surname, address, phone, birthday);
    }

    @Override
    public void deleteCourier(Integer id) throws SQLException {
        courier.delete(id);
    }

    public void findAllOperators() throws SQLException {
        operator.findAll();
    }

    @Override
    public void findOperatorById(Integer id) throws SQLException {
        operator.findById(id);
    }

    @Override
    public void createOperator(Integer departmentId, String name, String surname, String address,
                              BigDecimal phone, Date birthday) throws SQLException {
        operator.create(departmentId, name, surname, address, phone, birthday);
    }

    @Override
    public void updateOperator(Integer id, Integer departmentId, String name, String surname,
                              String address, BigDecimal phone, Date birthday) throws SQLException {
        operator.update(id, departmentId, name, surname, address, phone, birthday);
    }

    @Override
    public void deleteOperator(Integer id) throws SQLException {
        operator.delete(id);
    }

    @Override
    public void findAllDepartments() throws SQLException {
        department.findAll();
    }

    @Override
    public void findDepartmentById(Integer id) throws SQLException {
        department.findById(id);
    }

    @Override
    public void createDepartment(String departmentTypeSize, String cityName, Integer number, String address)
            throws SQLException {
        department.create(departmentTypeSize, cityName, number, address);
    }

    @Override
    public void updateDepartment(Integer id, String departmentTypeSize, String cityName, Integer number,
                                 String address) throws SQLException {
        department.update(id, departmentTypeSize, cityName, number, address);
    }

    @Override
    public void deleteDepartment(Integer id) throws SQLException {
        department.delete(id);
    }

    @Override
    public void findAllDepartmentTypes() throws SQLException {
        departmentType.findAll();
    }

    @Override
    public void findDepartmentTypeById(String size) throws SQLException {
        departmentType.findById(size);
    }

    @Override
    public void createDepartmentType(String size, Integer maxWeight) throws SQLException {
        departmentType.create(size, maxWeight);
    }

    @Override
    public void updateDepartmentType(String size, Integer maxWeight, String newSize) throws SQLException {
        departmentType.update(size, maxWeight, newSize);
    }

    @Override
    public void deleteDepartmentType(String size) throws SQLException {
        departmentType.delete(size);
    }
}
