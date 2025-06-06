package com.example.annotations.pathVariable;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PathVariableInput1")
public class PathVariableInput1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the PathVariableInput1";
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return serviceClass1.getEmployeeById(id);
    }
}
