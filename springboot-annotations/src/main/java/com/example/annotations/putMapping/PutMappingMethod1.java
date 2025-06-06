package com.example.annotations.putMapping;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PutMappingMethod1")
public class PutMappingMethod1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the PutMappingMethod1";
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return serviceClass1.updateEmployee(employee);
    }
}
