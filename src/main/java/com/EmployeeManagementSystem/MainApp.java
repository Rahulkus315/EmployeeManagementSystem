package com.employeemanagementsystem;

import com.employeemanagementsystem.controller.EmployeeController;

public class MainApp {
    public static void main(String[] args) {
        EmployeeController controller = new EmployeeController();
        controller.start();
    }
}
