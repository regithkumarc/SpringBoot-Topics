package com.example.annotations.controllerAdvice;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ControlAdviceClass1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = serviceClass1.getEmployeeById(id);
        if(Objects.nonNull(employee)) {
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        } else {
            throw new EmployeeNotFoundException(employee.getName());
        }
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = serviceClass1.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.FOUND);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addEmployee = serviceClass1.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = serviceClass1.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable int id) {
        boolean deleteStatus = serviceClass1.deleteEmployeeById(id);
        if(deleteStatus) {
            return new ResponseEntity<>(deleteStatus, HttpStatus.FOUND);
        } else {
            throw new EmployeeNotFoundException(String.valueOf(id));
        }

    }
}
