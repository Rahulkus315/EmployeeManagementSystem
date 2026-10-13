package com.employeemanagementsystem.service;

import com.employeemanagementsystem.dao.EmployeeDAO;
import com.employeemanagementsystem.dao.EmployeeDAOImpl;
import com.employeemanagementsystem.model.Employee;

import java.util.List;

public class EmployeeService {
    private final EmployeeDAO dao = new EmployeeDAOImpl();

    public void addEmployee(Employee employee) {
        if (employee == null
                || employee.getName() == null
                || employee.getName().isBlank()
                || employee.getEmail() == null
                || employee.getEmail().isBlank()
                || employee.getDept() == null
                || employee.getDept().isBlank()
                || employee.getSalary() <= 0) {

            System.out.println("Invalid employee details.");
            return;
        }

        if (dao.existsByEmail(employee.getEmail().trim())) {
            System.out.println("Error: Email already exists!");
            return;
        }

        employee.setEmail(employee.getEmail().trim());
        dao.addEmployee(employee);
    }

    public void viewAllEmployee() {
        List<Employee> list = dao.getAllEmployee();
        if (list.isEmpty()) {
            System.out.println("No data found");
            return;
        }
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public void searchById(int id) {
        Employee employee = dao.getEmployeeById(id);
        if (employee == null) {
            System.out.println("Not found");
        } else {
            System.out.println(employee);
        }
    }

    public void searchByName(String name) {
        List<Employee> list = dao.searchByName(name);
        if (list.isEmpty()) {
            System.out.println("No matching record found");
            return;
        }
        list.forEach(System.out::println);
    }

    public void updateEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }
        if (dao.getEmployeeById(employee.getId()) == null) {
            System.out.println("Employee not found!");
            return;
        }
        dao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        if (dao.getEmployeeById(id) == null) {
            System.out.println("Employee not found!");
            return;
        }
        dao.deleteEmployee(id);
    }
}
