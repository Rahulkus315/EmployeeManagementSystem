package com.employeemanagementsystem.dao;

import com.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    List<Employee> searchByName(String name);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    boolean existsByEmail(String email);
}
