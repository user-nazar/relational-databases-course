package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class MyView {
    private static Controller controller;
    private static String submenu =
            "\t1 - Find all\n\t2 - Find by id\n\t3 - Create\n\t4 - Update\n\t5 - Delete\n\tQ - Go back\n";

    public MyView() {
        controller = new Controller();
    }

    public void show() throws SQLException {
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

    private void workWithAccount() throws SQLException {
        System.out.println("\tTable 'account'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllAccounts();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findAccountById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter username: ");
                String username = new Scanner(System.in).nextLine();
                System.out.print("Enter password: ");
                String password = new Scanner(System.in).nextLine();
                System.out.print("Enter email: ");
                String email = new Scanner(System.in).nextLine();
                controller.createAccount(id, username, password, email);
                break;
            case "4":
                System.out.print("Enter id: ");
                Integer xId = new Scanner(System.in).nextInt();
                System.out.print("Enter new username: ");
                String newUsername = new Scanner(System.in).nextLine();
                System.out.print("Enter new password: ");
                String newPassword = new Scanner(System.in).nextLine();
                System.out.print("Enter new email: ");
                String newEmail = new Scanner(System.in).nextLine();
                controller.updateAccount(xId, newUsername, newPassword, newEmail);
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

    private void workWithCity() throws SQLException {
        System.out.println("\tTable 'city'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllCities();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findCityById(new Scanner(System.in).nextLine());
                break;
            case "3":
                System.out.print("Enter city: ");
                controller.createCity(new Scanner(System.in).nextLine());
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

    private void workWithClient() throws SQLException {
        System.out.println("\tTable 'client'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllClients();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findClientById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter surname: ");
                String surname = new Scanner(System.in).nextLine();
                System.out.print("Enter phone: ");
                BigDecimal phone = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter address: ");
                String address = new Scanner(System.in).nextLine();
                controller.createClient(name, surname, phone, address);
                break;
            case "4":
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String newName = new Scanner(System.in).nextLine();
                System.out.print("Enter new surname: ");
                String newSurname = new Scanner(System.in).nextLine();
                System.out.print("Enter new phone: ");
                BigDecimal newPhone = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter new address: ");
                String newAddress = new Scanner(System.in).nextLine();
                controller.updateClient(id, newName, newSurname, newPhone, newAddress);
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

    private void workWithCourier() throws SQLException {
        System.out.println("\tTable 'courier'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllCouriers();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findCourierById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter department_id: ");
                Integer departmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter surname: ");
                String surname = new Scanner(System.in).nextLine();
                System.out.print("Enter address: ");
                String address = new Scanner(System.in).nextLine();
                System.out.print("Enter phone: ");
                BigDecimal phone = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter birthday: ");
                Date birthday = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.createCourier(departmentId, name, surname, address, phone, birthday);
                break;
            case "4":
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter new department_id: ");
                Integer newDepartmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter new name: ");
                String newName = new Scanner(System.in).nextLine();
                System.out.print("Enter new surname: ");
                String newSurname = new Scanner(System.in).nextLine();
                System.out.print("Enter new address: ");
                String newAddress = new Scanner(System.in).nextLine();
                System.out.print("Enter new phone: ");
                BigDecimal newPhone = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter new birthday: ");
                Date newBirthday = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.updateCourier(id, newDepartmentId, newName, newSurname, newAddress, newPhone, newBirthday);
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

    private void workWithDepartment() throws SQLException {
        System.out.println("\tTable 'department'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllDepartments();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findDepartmentById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter department_type_size: ");
                String departmentTypeSize = new Scanner(System.in).nextLine();
                System.out.print("Enter city_name: ");
                String cityName = new Scanner(System.in).nextLine();
                System.out.print("Enter number: ");
                Integer number = new Scanner(System.in).nextInt();
                System.out.print("Enter address: ");
                String address = new Scanner(System.in).nextLine();
                controller.createDepartment(departmentTypeSize, cityName, number, address);
                break;
            case "4":
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter department_type_size: ");
                String newDepartmentTypeSize = new Scanner(System.in).nextLine();
                System.out.print("Enter city_name: ");
                String newCityName = new Scanner(System.in).nextLine();
                System.out.print("Enter number: ");
                Integer newNumber = new Scanner(System.in).nextInt();
                System.out.print("Enter address: ");
                String newAddress = new Scanner(System.in).nextLine();
                controller.updateDepartment(id, newDepartmentTypeSize, newCityName, newNumber, newAddress);
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

    private void workWithDepartmentType() throws SQLException {
        System.out.println("\tTable 'department_type'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllDepartmentTypes();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findDepartmentTypeById(new Scanner(System.in).nextLine());
                break;
            case "3":
                System.out.print("Enter size: ");
                String size = new Scanner(System.in).nextLine();
                System.out.print("Enter max_weight: ");
                Integer maxWeight = new Scanner(System.in).nextInt();
                controller.createDepartmentType(size, maxWeight);
                break;
            case "4":
                System.out.print("Enter size: ");
                String xSize = new Scanner(System.in).nextLine();
                System.out.print("Enter new size: ");
                String newSize = new Scanner(System.in).nextLine();
                System.out.print("Enter new max_weight: ");
                Integer newMaxWeight = new Scanner(System.in).nextInt();
                controller.updateDepartmentType(xSize, newMaxWeight, newSize);
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

    private void workWithOperator() throws SQLException {
        System.out.println("\tTable 'operator'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllOperators();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findOperatorById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter department_id: ");
                Integer departmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter surname: ");
                String surname = new Scanner(System.in).nextLine();
                System.out.print("Enter address: ");
                String address = new Scanner(System.in).nextLine();
                System.out.print("Enter phone: ");
                BigDecimal phone = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter birthday: ");
                Date birthday = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.createOperator(departmentId, name, surname, address, phone, birthday);
                break;
            case "4":
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter new department_id: ");
                Integer newDepartmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter new name: ");
                String newName = new Scanner(System.in).nextLine();
                System.out.print("Enter new surname: ");
                String newSurname = new Scanner(System.in).nextLine();
                System.out.print("Enter new address: ");
                String newAddress = new Scanner(System.in).nextLine();
                System.out.print("Enter new phone: ");
                BigDecimal newPhone = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter new birthday: ");
                Date newBirthday = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.updateOperator(id, newDepartmentId, newName, newSurname, newAddress, newPhone, newBirthday);
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

    private void workWithOrder() throws SQLException {
        System.out.println("\tTable 'order'");
        System.out.println(submenu);
        System.out.print("Select point: ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                controller.findAllOrders();
                break;
            case "2":
                System.out.print("Enter id: ");
                controller.findOrderById(new Scanner(System.in).nextInt());
                break;
            case "3":
                System.out.print("Enter from_department_id: ");
                Integer fromDepartmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter to_department_id: ");
                Integer toDepartmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter from_operator_id: ");
                Integer fromOperatorId = new Scanner(System.in).nextInt();
                System.out.print("Enter to_operator_id: ");
                Integer toOperatorId = new Scanner(System.in).nextInt();
                System.out.print("Enter from_courier_id: ");
                Integer fromCourierId = new Scanner(System.in).nextInt();
                System.out.print("Enter to_courier_id: ");
                Integer toCourierId = new Scanner(System.in).nextInt();
                System.out.print("Enter from_client_id: ");
                Integer fromClientId = new Scanner(System.in).nextInt();
                System.out.print("Enter to_client_id: ");
                Integer toClientId = new Scanner(System.in).nextInt();
                System.out.print("Enter delivery_price: ");
                BigDecimal deliveryPrice = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter product_price: ");
                BigDecimal productPrice = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter weight: ");
                Integer weight = new Scanner(System.in).nextInt();
                System.out.print("Enter sending_date: ");
                Date sendingDate = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter approximate_arrival_date: ");
                Date approximateArrivalDate = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter fixed_arrival_date: ");
                Date fixedArrivalDate = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.createOrder(fromDepartmentId, toDepartmentId, fromOperatorId, toOperatorId, fromCourierId,
                        toCourierId, fromClientId, toClientId, deliveryPrice, productPrice, weight, sendingDate,
                        approximateArrivalDate, fixedArrivalDate);
                break;
            case "4":
                System.out.print("Enter id: ");
                Integer id = new Scanner(System.in).nextInt();
                System.out.print("Enter new from_department_id: ");
                Integer newFromDepartmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter new to_department_id: ");
                Integer newToDepartmentId = new Scanner(System.in).nextInt();
                System.out.print("Enter new from_operator_id: ");
                Integer newFromOperatorId = new Scanner(System.in).nextInt();
                System.out.print("Enter new to_operator_id: ");
                Integer newToOperatorId = new Scanner(System.in).nextInt();
                System.out.print("Enter new from_courier_id: ");
                Integer newFromCourierId = new Scanner(System.in).nextInt();
                System.out.print("Enter new to_courier_id: ");
                Integer newToCourierId = new Scanner(System.in).nextInt();
                System.out.print("Enter new from_client_id: ");
                Integer newFromClientId = new Scanner(System.in).nextInt();
                System.out.print("Enter new to_client_id: ");
                Integer newToClientId = new Scanner(System.in).nextInt();
                System.out.print("Enter new delivery_price: ");
                BigDecimal newDeliveryPrice = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter new product_price: ");
                BigDecimal newProductPrice = new Scanner(System.in).nextBigDecimal();
                System.out.print("Enter new weight: ");
                Integer newWeight = new Scanner(System.in).nextInt();
                System.out.print("Enter new sending_date: ");
                Date newSendingDate = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter new approximate_arrival_date: ");
                Date newApproximateArrivalDate = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                System.out.print("Enter new fixed_arrival_date: ");
                Date newFixedArrivalDate = new Date(System.currentTimeMillis()).valueOf(new Scanner(System.in).nextLine());
                controller.updateOrder(id, newFromDepartmentId, newToDepartmentId, newFromOperatorId, newToOperatorId,
                        newFromCourierId, newToCourierId, newFromClientId, newToClientId, newDeliveryPrice,
                        newProductPrice, newWeight, newSendingDate, newApproximateArrivalDate, newFixedArrivalDate);
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
