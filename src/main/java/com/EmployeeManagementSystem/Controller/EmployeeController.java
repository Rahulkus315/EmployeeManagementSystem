package com.employeemanagementsystem.controller;

import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.service.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private final Scanner sc = new Scanner(System.in);
    private final EmployeeService service = new EmployeeService();

    public void start() {
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            handleChoice(choice);
        }
    }

    private void showMenu() {
        System.out.println("======================== EMPLOYEE MANAGEMENT SYSTEM ========================");
        System.out.println("1. Add Employee");
        System.out.println("2. View all Employee");
        System.out.println("3. Search by ID");
        System.out.println("4. Search by Name");
        System.out.println("5. Update Employee");
        System.out.println("6. Delete Employee");
        System.out.println("7. Exit");
        System.out.print("Enter your choice : ");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                service.viewAllEmployee();
                break;
            case 3:
                System.out.print("Enter ID : ");
                service.searchById(sc.nextInt());
                break;
            case 4:
                System.out.print("Enter Name : ");
                service.searchByName(sc.nextLine());
                break;
            case 5:
                updateEmployee();
                break;
            case 6:
                System.out.print("Enter ID : ");
                service.deleteEmployee(sc.nextInt());
                break;
            case 7:
                System.out.print("Exit");
                System.exit(0);
            default:
                System.out.println("Invalid input.....");
        }
    }

    private void addEmployee() {
        System.out.print("Enter employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter employee name : ");
        String name = sc.nextLine();
        System.out.print("Enter department : ");
        String dept = sc.nextLine();
        System.out.print("Enter salary : ");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter email : ");
        String email = sc.nextLine();

        Employee employee = new Employee(id, name, dept, salary, email);
        service.addEmployee(employee);
    }

    private void updateEmployee() {
        System.out.print("Enter employee ID to update : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new name : ");
        String name = sc.nextLine();
        System.out.print("Enter new department : ");
        String dept = sc.nextLine();
        System.out.print("Enter new salary : ");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter new email : ");
        String email = sc.nextLine();

        service.updateEmployee(new Employee(id, name, dept, salary, email));
    }
}
