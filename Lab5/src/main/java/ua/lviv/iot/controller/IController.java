package ua.lviv.iot.controller;

import ua.lviv.iot.model.AccountEntity;
import ua.lviv.iot.model.CityEntity;
import ua.lviv.iot.model.ClientEntity;
import ua.lviv.iot.model.CourierEntity;
import ua.lviv.iot.model.DepartmentEntity;
import ua.lviv.iot.model.DepartmentTypeEntity;
import ua.lviv.iot.model.OperatorEntity;
import ua.lviv.iot.model.OrderEntity;

import java.util.List;

public interface IController {

    List<OrderEntity> findAllOrders() throws Exception;

    OrderEntity findOrderById(Integer id) throws Exception;

    void createOrder(OrderEntity entity) throws Exception;

    void updateOrder(OrderEntity entity) throws Exception;

    void deleteOrder(Integer id) throws Exception;

    List<ClientEntity> findAllClients() throws Exception;

    ClientEntity findClientById(Integer id) throws Exception;

    void createClient(ClientEntity entity) throws Exception;

    void updateClient(ClientEntity entity) throws Exception;

    void deleteClient(Integer id) throws Exception;

    List<AccountEntity> findAllAccounts() throws Exception;

    AccountEntity findAccountById(Integer id) throws Exception;

    void createAccount(AccountEntity entity) throws Exception;

    void updateAccount(AccountEntity entity) throws Exception;

    void deleteAccount(Integer id) throws Exception;

    List<CityEntity> findAllCities() throws Exception;

    CityEntity findCityById(String id) throws Exception;

    void createCity(CityEntity entity) throws Exception;

    void updateCity(String city, String newCity) throws Exception;

    void deleteCity(String id) throws Exception;

    List<CourierEntity> findAllCouriers() throws Exception;

    CourierEntity findCourierById(Integer id) throws Exception;

    void createCourier(CourierEntity entity) throws Exception;

    void updateCourier(CourierEntity entity) throws Exception;

    void deleteCourier(Integer id) throws Exception;

    List<OperatorEntity> findAllOperators() throws Exception;

    OperatorEntity findOperatorById(Integer id) throws Exception;

    void createOperator(OperatorEntity entity) throws Exception;

    void updateOperator(OperatorEntity entity) throws Exception;

    void deleteOperator(Integer id) throws Exception;

    List<DepartmentEntity> findAllDepartments() throws Exception;

    DepartmentEntity findDepartmentById(Integer id) throws Exception;

    void createDepartment(DepartmentEntity entity)
            throws Exception;

    void updateDepartment(DepartmentEntity entity)
            throws Exception;

    void deleteDepartment(Integer id) throws Exception;

    List<DepartmentTypeEntity> findAllDepartmentTypes() throws Exception;

    DepartmentTypeEntity findDepartmentTypeById(String id) throws Exception;

    void createDepartmentType(DepartmentTypeEntity entity) throws Exception;

    void updateDepartmentType(DepartmentTypeEntity entity) throws Exception;

    void deleteDepartmentType(String id) throws Exception;
}
