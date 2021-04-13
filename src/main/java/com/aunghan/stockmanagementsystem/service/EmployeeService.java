package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    String deleteEmployee(int id);
    Employee updateEmployee(Employee employee);
    Employee getEmployeeById(int id);
    Employee getEmployeeByUsername(String username);
    Employee getEmployeeByEmail(String email);
}
