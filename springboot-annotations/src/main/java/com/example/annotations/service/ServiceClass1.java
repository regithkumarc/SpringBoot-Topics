package com.example.annotations.service;

import com.example.annotations.model.Employee;
import com.example.annotations.repository.RepositoryInterface1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClass1 implements  ServiceClassImpl1 {

    @Autowired
    private RepositoryInterface1 repositoryInterface1;

    @Override
    public Employee getEmployeeById(int id) {
        return repositoryInterface1.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repositoryInterface1.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return repositoryInterface1.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repositoryInterface1.save(employee);
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        Optional<Employee> optional = repositoryInterface1.findById(id);
        if(optional.isPresent()) {
            repositoryInterface1.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
