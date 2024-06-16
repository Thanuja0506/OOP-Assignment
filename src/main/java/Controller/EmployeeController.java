/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */




package Controller;

import Model.Employee;
import Model.EmployeeDAO;
import java.util.List;

public class EmployeeController {
    public static boolean registerEmployee(String fullName, String username, String password) {
        Employee employee = new Employee(0, fullName, username, password); 
        return EmployeeDAO.registerEmployee(employee);
    }

    public static boolean loginEmployee(String username, String password) {
        return EmployeeDAO.loginEmployee(username, password);
    }

    public static List<Employee> getAllEmployees() {
        return EmployeeDAO.getAllEmployees();
    }
    
     public static Employee getEmployeeById(int id) {
        return EmployeeDAO.getEmployeeById(id);
    }
}
