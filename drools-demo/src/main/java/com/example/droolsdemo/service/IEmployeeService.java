package com.example.droolsdemo.service;

import com.example.droolsdemo.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
}
