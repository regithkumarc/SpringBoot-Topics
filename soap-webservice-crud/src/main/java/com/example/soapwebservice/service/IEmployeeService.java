package com.example.soapwebservice.service;

import com.example.soapwebservice.entity.Employees;

import java.util.List;

public interface IEmployeeService {
    List<Employees> getAllEmployees();
    Employees getEmployeeById(Long employeeId);
    Employees addEmployee(Employees employees);
    void updateEmployee(Employees employees);
    void deleteEmployeeById(Employees employees);
}
