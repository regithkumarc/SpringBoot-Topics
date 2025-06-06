package com.example.annotations.service;

import com.example.annotations.model.Employee;

import java.util.List;

public interface ServiceClassImpl1 {
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployeeById(int id);
}
