package com.example.annotations.getMapping;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/GetMappingMethod1")
public class GetMappingMethod1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the GetMappingMethod1";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return serviceClass1.getAllEmployees();
    }
}
