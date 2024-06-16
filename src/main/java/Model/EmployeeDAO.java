/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */



import Project.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static boolean registerEmployee(Employee employee) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO employee(fullname, username, password) VALUES (?, ?, ?)");
            ps.setString(1, employee.getFullName());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getPassword());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean loginEmployee(String username, String password) {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), rs.getString("password"));
                employees.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return employees;
    }
    
    
    
    public static Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), rs.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return employee;
    }
    
}
