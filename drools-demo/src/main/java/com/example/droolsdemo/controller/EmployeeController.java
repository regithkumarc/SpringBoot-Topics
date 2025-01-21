package com.example.droolsdemo.controller;

import com.example.droolsdemo.entity.Employee;
import com.example.droolsdemo.service.EmployeeService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private KieSession kieSession;

    @GetMapping("/getEmployeeController")
    public String getEmployeeController() {
        return "Getting the EmployeeController";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        kieSession.insert(employee);
        kieSession.fireAllRules();
        return employeeService.addEmployee(employee);
    }
}
