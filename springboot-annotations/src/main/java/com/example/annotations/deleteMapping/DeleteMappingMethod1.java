package com.example.annotations.deleteMapping;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DeleteMappingMethod1")
public class DeleteMappingMethod1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the DeleteMappingMethod1";
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeById(@PathVariable int id) {
        return serviceClass1.deleteEmployeeById(id);
    }
}
