package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.AccountEntity;
import ua.lviv.iot.model.CityEntity;
import ua.lviv.iot.model.ClientEntity;
import ua.lviv.iot.model.CourierEntity;
import ua.lviv.iot.model.DepartmentEntity;
import ua.lviv.iot.model.DepartmentTypeEntity;
import ua.lviv.iot.model.OperatorEntity;
import ua.lviv.iot.model.OrderEntity;

import java.sql.Date;
import java.util.Scanner;

public class MyView {
    private static Controller controller;
    private static String submenu =
            "\t1 - Find all\n\t2 - Find by id\n\t3 - Create\n\t4 - Update\n\t5 - Delete\n\tQ - Go back\n";

    public MyView() {
        controller = new Controller();
    }

    public void show() throws Exception {
        String menuPoint;
        do {
            System.out.println("Press ENTER key to continue...");
            new Scanner(System.in).nextLine();

            outputMenu();
            System.out.print("\nPlease, select menu point: ");
            menuPoint = new Scanner(System.in).nextLine().toUpperCase();

            switch (menuPoint) {
                case "1":
                    workWithAccount();
                    break;
                case "2":
                    workWithCity();
                    break;
                case "3":
                    workWithClient();
                    break;
                case "4":
                    workWithCourier();
                    break;
                case "5":
                    workWithDepartment();
                    break;
                case "6":
                    workWithDepartmentType();
                    break;
                case "7":
                    workWithOperator();
                    break;
                case "8":
                    workWithOrder();
                    break;
                case "Q":
                    System.out.println("\n\nBye!");
                    break;
                default:
                    System.out.println("Menu point does not exist!");
            }
        } while (!menuPoint.equals("Q"));
    }

    private void outputMenu() {
        System.out.println("\t\tMenu");
        System.out.println("(Choose Table to work with:)");
        System.out.print("\t1 - Account\n" + "\t2 - City\n" + "\t3 - Client\n" + "\t4 - Courier\n" +
                "\t5 - Department\n" + "\t6 - DepartmentType\n" + "\t7 - Operator\n" + "\t8 - Order\n" +
                "\tQ - Exit\n");
    }

    private void workWithAccount() throws Exception {
        AccountEntity entity;
        System.out.println("\tTable 'account'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (AccountEntity account : controller.findAllAccounts()) {
                    System.out.println(account);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.println(controller.findAccountById(new Scanner(System.in).nextInt()));
                break;
            case "3":
                entity = new AccountEntity();
                System.out.print("Enter id: ");
                entity.setClientId(new Scanner(System.in).nextInt());
                System.out.print("Enter username: ");
                entity.setUsername(new Scanner(System.in).nextLine());
                System.out.print("Enter password: ");
                entity.setPassword(new Scanner(System.in).nextLine());
                System.out.print("Enter email: ");
                entity.setEmail(new Scanner(System.in).nextLine());
                controller.createAccount(entity);
                break;
            case "4":
                entity = new AccountEntity();
                System.out.print("Enter id: ");
                entity.setClientId(new Scanner(System.in).nextInt());
                System.out.print("Enter new username: ");
                entity.setUsername(new Scanner(System.in).nextLine());
                System.out.print("Enter new password: ");
                entity.setPassword(new Scanner(System.in).nextLine());
                System.out.print("Enter new email: ");
                entity.setEmail(new Scanner(System.in).nextLine());
                controller.updateAccount(entity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteAccount(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void workWithCity() throws Exception {
        CityEntity entity;
        System.out.println("\tTable 'city'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (CityEntity city : controller.findAllCities()) {
                    System.out.println(city);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.print(controller.findCityById(new Scanner(System.in).nextLine()));
                break;
            case "3":
                entity = new CityEntity();
                System.out.print("Enter city: ");
                entity.setName(new Scanner(System.in).nextLine());
                controller.createCity(entity);
                break;
            case "4":
                System.out.print("Enter city: ");
                String city = new Scanner(System.in).nextLine();
                System.out.print("Enter new city: ");
                String newCity = new Scanner(System.in).nextLine();
                controller.updateCity(city, newCity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteCity(new Scanner(System.in).nextLine());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void workWithClient() throws Exception {
        ClientEntity entity;
        System.out.println("\tTable 'client'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (ClientEntity client : controller.findAllClients()) {
                    System.out.println(client);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.println(controller.findClientById(new Scanner(System.in).nextInt()));
                break;
            case "3":
                entity = new ClientEntity();
                System.out.print("Enter name: ");
                entity.setName(new Scanner(System.in).nextLine());
                System.out.print("Enter surname: ");
                entity.setSurname(new Scanner(System.in).nextLine());
                System.out.print("Enter phone: ");
                entity.setPhone(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                controller.createClient(entity);
                break;
            case "4":
                entity = new ClientEntity();
                System.out.print("Enter id: ");
                entity.setId(new Scanner(System.in).nextInt());
                System.out.print("Enter new name: ");
                entity.setName(new Scanner(System.in).nextLine());
                System.out.print("Enter new surname: ");
                entity.setSurname(new Scanner(System.in).nextLine());
                System.out.print("Enter new phone: ");
                entity.setPhone(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter new address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                controller.updateClient(entity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteClient(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void workWithCourier() throws Exception {
        CourierEntity entity;
        System.out.println("\tTable 'courier'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (CourierEntity courier : controller.findAllCouriers()) {
                    System.out.println(courier);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.println(controller.findCourierById(new Scanner(System.in).nextInt()));
                break;
            case "3":
                entity = new CourierEntity();
                System.out.print("Enter department_id: ");
                entity.setDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter name: ");
                entity.setName(new Scanner(System.in).nextLine());
                System.out.print("Enter surname: ");
                entity.setSurname(new Scanner(System.in).nextLine());
                System.out.print("Enter phone: ");
                entity.setPhone(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                System.out.print("Enter birthday: ");
                entity.setBirthday(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                controller.createCourier(entity);
                break;
            case "4":
                entity = new CourierEntity();
                System.out.print("Enter id: ");
                entity.setId(new Scanner(System.in).nextInt());
                System.out.print("Enter new department_id: ");
                entity.setDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter new name: ");
                entity.setName(new Scanner(System.in).nextLine());
                System.out.print("Enter new surname: ");
                entity.setSurname(new Scanner(System.in).nextLine());
                System.out.print("Enter new phone: ");
                entity.setPhone(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter new address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                System.out.print("Enter new birthday: ");
                entity.setBirthday(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                controller.updateCourier(entity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteCourier(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void workWithDepartment() throws Exception {
        DepartmentEntity entity;
        System.out.println("\tTable 'department'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (DepartmentEntity department : controller.findAllDepartments()) {
                    System.out.println(department);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.println(controller.findDepartmentById(new Scanner(System.in).nextInt()));
                break;
            case "3":
                entity = new DepartmentEntity();
                System.out.print("Enter department_type_size: ");
                entity.setDepartmentTypeSize(new Scanner(System.in).nextLine());
                System.out.print("Enter city_name: ");
                entity.setCityName(new Scanner(System.in).nextLine());
                System.out.print("Enter number: ");
                entity.setNumber(new Scanner(System.in).nextInt());
                System.out.print("Enter address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                controller.createDepartment(entity);
                break;
            case "4":
                entity = new DepartmentEntity();
                System.out.print("Enter id: ");
                entity.setId(new Scanner(System.in).nextInt());
                System.out.print("Enter new department_type_size: ");
                entity.setDepartmentTypeSize(new Scanner(System.in).nextLine());
                System.out.print("Enter new city_name: ");
                entity.setCityName(new Scanner(System.in).nextLine());
                System.out.print("Enter new number: ");
                entity.setNumber(new Scanner(System.in).nextInt());
                System.out.print("Enter new address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                controller.updateDepartment(entity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteDepartment(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void workWithDepartmentType() throws Exception {
        DepartmentTypeEntity entity;
        System.out.println("\tTable 'department_type'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (DepartmentTypeEntity departmentType : controller.findAllDepartmentTypes()) {
                    System.out.println(departmentType);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.println(controller.findDepartmentTypeById(new Scanner(System.in).nextLine()));
                break;
            case "3":
                entity = new DepartmentTypeEntity();
                System.out.print("Enter size: ");
                entity.setSize(new Scanner(System.in).nextLine());
                System.out.print("Enter max_weight: ");
                entity.setMaxWeight(new Scanner(System.in).nextInt());
                controller.createDepartmentType(entity);
                break;
            case "4":
                entity = new DepartmentTypeEntity();
                System.out.print("Enter size: ");
                entity.setSize(new Scanner(System.in).nextLine());
                System.out.print("Enter new max_weight: ");
                entity.setMaxWeight(new Scanner(System.in).nextInt());
                controller.updateDepartmentType(entity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteDepartmentType(new Scanner(System.in).nextLine());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void workWithOperator() throws Exception {
        OperatorEntity entity;
        System.out.println("\tTable 'operator'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (OperatorEntity operator : controller.findAllOperators()) {
                    System.out.println(operator);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.println(controller.findCourierById(new Scanner(System.in).nextInt()));
                break;
            case "3":
                entity = new OperatorEntity();
                System.out.print("Enter department_id: ");
                entity.setDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter name: ");
                entity.setName(new Scanner(System.in).nextLine());
                System.out.print("Enter surname: ");
                entity.setSurname(new Scanner(System.in).nextLine());
                System.out.print("Enter phone: ");
                entity.setPhone(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                System.out.print("Enter birthday: ");
                entity.setBirthday(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                controller.createOperator(entity);
                break;
            case "4":
                entity = new OperatorEntity();
                System.out.print("Enter id: ");
                entity.setId(new Scanner(System.in).nextInt());
                System.out.print("Enter new department_id: ");
                entity.setDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter new name: ");
                entity.setName(new Scanner(System.in).nextLine());
                System.out.print("Enter new surname: ");
                entity.setSurname(new Scanner(System.in).nextLine());
                System.out.print("Enter new phone: ");
                entity.setPhone(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter new address: ");
                entity.setAddress(new Scanner(System.in).nextLine());
                System.out.print("Enter new birthday: ");
                entity.setBirthday(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                controller.updateOperator(entity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteOperator(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void workWithOrder() throws Exception {
        OrderEntity entity;
        System.out.println("\tTable 'order'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                for (OrderEntity order : controller.findAllOrders()) {
                    System.out.println(order);
                }
                break;
            case "2":
                System.out.print("Enter id: ");
                System.out.println(controller.findOrderById(new Scanner(System.in).nextInt()));
                break;
            case "3":
                entity = new OrderEntity();
                System.out.print("Enter from_department_id: ");
                entity.setFromDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter to_department_id: ");
                entity.setToDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter from_operator_id: ");
                entity.setFromOperatorId(new Scanner(System.in).nextInt());
                System.out.print("Enter to_operator_id: ");
                entity.setToOperatorId(new Scanner(System.in).nextInt());
                System.out.print("Enter from_courier_id: ");
                entity.setFromCourierId(new Scanner(System.in).nextInt());
                System.out.print("Enter to_courier_id: ");
                entity.setToCourierId(new Scanner(System.in).nextInt());
                System.out.print("Enter from_client_id: ");
                entity.setFromClientId(new Scanner(System.in).nextInt());
                System.out.print("Enter to_client_id: ");
                entity.setToClientId(new Scanner(System.in).nextInt());
                System.out.print("Enter delivery_price: ");
                entity.setDeliveryPrice(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter product_price: ");
                entity.setProductPrice(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter weight: ");
                entity.setWeight(new Scanner(System.in).nextInt());
                System.out.print("Enter sending_date: ");
                entity.setSendingDate(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                System.out.print("Enter approximate_arrival_date: ");
                entity.setApproximateArrivalDate(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                System.out.print("Enter fixed_arrival_date: ");
                entity.setFixedArrivalDate(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                controller.createOrder(entity);
                break;
            case "4":
                entity = new OrderEntity();
                System.out.print("Enter id: ");
                entity.setId(new Scanner(System.in).nextInt());
                System.out.print("Enter new from_department_id: ");
                entity.setFromDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter new to_department_id: ");
                entity.setToDepartmentId(new Scanner(System.in).nextInt());
                System.out.print("Enter new from_operator_id: ");
                entity.setFromOperatorId(new Scanner(System.in).nextInt());
                System.out.print("Enter new to_operator_id: ");
                entity.setToOperatorId(new Scanner(System.in).nextInt());
                System.out.print("Enter new from_courier_id: ");
                entity.setFromCourierId(new Scanner(System.in).nextInt());
                System.out.print("Enter new to_courier_id: ");
                entity.setToCourierId(new Scanner(System.in).nextInt());
                System.out.print("Enter new from_client_id: ");
                entity.setFromClientId(new Scanner(System.in).nextInt());
                System.out.print("Enter new to_client_id: ");
                entity.setToClientId(new Scanner(System.in).nextInt());
                System.out.print("Enter new delivery_price: ");
                entity.setDeliveryPrice(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter new product_price: ");
                entity.setProductPrice(new Scanner(System.in).nextBigDecimal());
                System.out.print("Enter new weight: ");
                entity.setWeight(new Scanner(System.in).nextInt());
                System.out.print("Enter new sending_date: ");
                entity.setSendingDate(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                System.out.print("Enter new approximate_arrival_date: ");
                entity.setApproximateArrivalDate(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                System.out.print("Enter new fixed_arrival_date: ");
                entity.setFixedArrivalDate(new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine()));
                controller.updateOrder(entity);
                break;
            case "5":
                System.out.print("Enter id: ");
                controller.deleteOrder(new Scanner(System.in).nextInt());
                break;
            case "Q":
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }
}
