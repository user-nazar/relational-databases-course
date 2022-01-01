package ua.lviv.iot.controller;

import ua.lviv.iot.model.AccountEntity;
import ua.lviv.iot.model.CityEntity;
import ua.lviv.iot.model.ClientEntity;
import ua.lviv.iot.model.CourierEntity;
import ua.lviv.iot.model.DepartmentEntity;
import ua.lviv.iot.model.DepartmentTypeEntity;
import ua.lviv.iot.model.OperatorEntity;
import ua.lviv.iot.model.OrderEntity;
import ua.lviv.iot.service.AccountService;
import ua.lviv.iot.service.CityService;
import ua.lviv.iot.service.ClientService;
import ua.lviv.iot.service.CourierService;
import ua.lviv.iot.service.DepartmentService;
import ua.lviv.iot.service.DepartmentTypeService;
import ua.lviv.iot.service.OperatorService;
import ua.lviv.iot.service.OrderService;

import java.util.List;

public class Controller implements IController {
    private static OrderService orderService;
    private static ClientService clientService;
    private static AccountService accountService;
    private static CityService cityService;
    private static CourierService courierService;
    private static OperatorService operatorService;
    private static DepartmentService departmentService;
    private static DepartmentTypeService departmentTypeService;

    public Controller() {
        orderService = new OrderService();
        clientService = new ClientService();
        accountService = new AccountService();
        cityService = new CityService();
        courierService = new CourierService();
        operatorService = new OperatorService();
        departmentService = new DepartmentService();
        departmentTypeService = new DepartmentTypeService();
    }

    @Override
    public List<OrderEntity> findAllOrders() throws Exception {
        return orderService.findAll();
    }

    @Override
    public OrderEntity findOrderById(Integer id) throws Exception {
        return orderService.findById(id);
    }

    @Override
    public void createOrder(OrderEntity entity) throws Exception {
        orderService.create(entity);
    }

    @Override
    public void updateOrder(OrderEntity entity) throws Exception {
        orderService.update(entity);
    }

    @Override
    public void deleteOrder(Integer id) throws Exception {
        orderService.delete(id);
    }

    @Override
    public List<ClientEntity> findAllClients() throws Exception {
        return clientService.findAll();
    }

    @Override
    public ClientEntity findClientById(Integer id) throws Exception {
        return clientService.findById(id);
    }

    @Override
    public void createClient(ClientEntity entity) throws Exception {
        clientService.create(entity);
    }

    @Override
    public void updateClient(ClientEntity entity) throws Exception {
        clientService.update(entity);
    }

    @Override
    public void deleteClient(Integer id) throws Exception {
        clientService.delete(id);
    }

    @Override
    public List<AccountEntity> findAllAccounts() throws Exception {
        return accountService.findAll();
    }

    @Override
    public AccountEntity findAccountById(Integer id) throws Exception {
        return accountService.findById(id);
    }

    @Override
    public void createAccount(AccountEntity entity) throws Exception {
        accountService.create(entity);
    }

    @Override
    public void updateAccount(AccountEntity entity) throws Exception {
        accountService.update(entity);
    }

    @Override
    public void deleteAccount(Integer id) throws Exception {
        accountService.delete(id);
    }

    @Override
    public List<CityEntity> findAllCities() throws Exception {
        return cityService.findAll();
    }

    @Override
    public CityEntity findCityById(String id) throws Exception {
        return cityService.findById(id);
    }

    @Override
    public void createCity(CityEntity entity) throws Exception {
        cityService.create(entity);
    }

    @Override
    public void updateCity(String city, String newCity) throws Exception {
        cityService.update(city, newCity);
    }

    @Override
    public void deleteCity(String id) throws Exception {
        cityService.delete(id);
    }

    @Override
    public List<CourierEntity> findAllCouriers() throws Exception {
        return courierService.findAll();
    }

    @Override
    public CourierEntity findCourierById(Integer id) throws Exception {
        return courierService.findById(id);
    }

    @Override
    public void createCourier(CourierEntity entity) throws Exception {
        courierService.create(entity);
    }

    @Override
    public void updateCourier(CourierEntity entity) throws Exception {
        courierService.update(entity);
    }

    @Override
    public void deleteCourier(Integer id) throws Exception {
        courierService.delete(id);
    }

    @Override
    public List<OperatorEntity> findAllOperators() throws Exception {
        return operatorService.findAll();
    }

    @Override
    public OperatorEntity findOperatorById(Integer id) throws Exception {
        return operatorService.findById(id);
    }

    @Override
    public void createOperator(OperatorEntity entity) throws Exception {
        operatorService.create(entity);
    }

    @Override
    public void updateOperator(OperatorEntity entity) throws Exception {
        operatorService.update(entity);
    }

    @Override
    public void deleteOperator(Integer id) throws Exception {
        operatorService.delete(id);
    }

    @Override
    public List<DepartmentEntity> findAllDepartments() throws Exception {
        return departmentService.findAll();
    }

    @Override
    public DepartmentEntity findDepartmentById(Integer id) throws Exception {
        return departmentService.findById(id);
    }

    @Override
    public void createDepartment(DepartmentEntity entity) throws Exception {
        departmentService.create(entity);
    }

    @Override
    public void updateDepartment(DepartmentEntity entity) throws Exception {
        departmentService.update(entity);
    }

    @Override
    public void deleteDepartment(Integer id) throws Exception {
        departmentService.delete(id);
    }

    @Override
    public List<DepartmentTypeEntity> findAllDepartmentTypes() throws Exception {
        return departmentTypeService.findAll();
    }

    @Override
    public DepartmentTypeEntity findDepartmentTypeById(String id) throws Exception {
        return departmentTypeService.findById(id);
    }

    @Override
    public void createDepartmentType(DepartmentTypeEntity entity) throws Exception {
        departmentTypeService.create(entity);
    }

    @Override
    public void updateDepartmentType(DepartmentTypeEntity entity) throws Exception {
        departmentTypeService.update(entity);
    }

    @Override
    public void deleteDepartmentType(String id) throws Exception {
        departmentTypeService.delete(id);
    }
}
