package com.example.soapwebservice.controller;

import com.example.soapwebservice.articles.*;
import com.example.soapwebservice.employees.*;
import com.example.soapwebservice.service.SoapEmployeesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeesController {

    @Autowired
    private SoapEmployeesClient soapEmployeesClient;

    @GetMapping("/getNamesEmployeesController")
    public String getNamesEmployeesController() {
        return "Getting the EmployeesController";
    }

    @GetMapping("/getEmployeesById/{employeeId}")
    public GetEmployeesByIdResponse getEmployeesById(@PathVariable Long employeeId) {
        return soapEmployeesClient.getEmployeesById(employeeId);
    }

    @GetMapping("/getAllEmployees")
    public GetAllEmployeesResponse getAllEmployees() {
        return soapEmployeesClient.getAllEmployees();
    }

    @PostMapping("/addEmployees")
    public AddEmployeesResponse addEmployees(@RequestBody AddEmployeesRequest request) {
        return soapEmployeesClient.addEmployees(request);
    }

    @PutMapping("/updateEmployees")
    public UpdateEmployeesResponse updateEmployees(@RequestBody UpdateEmployeesRequest request) {
        return soapEmployeesClient.updateEmployees(request);
    }

    @DeleteMapping("/deleteEmployeesById/{employeeId}")
    public DeleteEmployeesResponse deleteEmployeesById(@PathVariable Long employeeId) {
        return soapEmployeesClient.deleteEmployeesById(employeeId);
    }
}
