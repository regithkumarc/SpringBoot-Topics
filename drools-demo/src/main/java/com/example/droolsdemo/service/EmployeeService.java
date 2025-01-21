package com.example.droolsdemo.service;

import com.example.droolsdemo.entity.Employee;
import com.example.droolsdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        Optional<Employee> optional = employeeRepository.findById(employee.getEmployeeId());
        return optional.orElse(null);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Optional<Employee> optional = employeeRepository.findById(employee.getEmployeeId());
        if (optional.isPresent()) {
            employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            employeeRepository.deleteById(id);
        }
    }
}
