package com.example.soapwebservice.service;

import com.example.soapwebservice.entity.Employees;
import com.example.soapwebservice.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees getEmployeeById(Long employeeId) {
        Optional<Employees> optional = employeesRepository.findById(employeeId);
        return optional.orElse(null);
    }

    @Override
    public Employees addEmployee(Employees employees) {
        employeesRepository.save(employees);
        Optional<Employees> optional = employeesRepository.findById(employees.getEmployeeId());
        return optional.orElse(null);
    }

    @Override
    public void updateEmployee(Employees employees) {
        Optional<Employees> optional = employeesRepository.findById(employees.getEmployeeId());
        if (optional.isPresent()) {
            employeesRepository.save(employees);
        }
    }

    @Override
    public void deleteEmployeeById(Employees employees) {
        Optional<Employees> optional = employeesRepository.findById(employees.getEmployeeId());
        if (optional.isPresent()) {
            employeesRepository.deleteById(employees.getEmployeeId());
        }
    }
}
