package com.example.annotations.requestparam;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RequestParamInput1")
public class RequestParamInput1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the RequestParamInput1";
    }

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(@RequestParam(value = "id",required = false) int id) {
        return serviceClass1.getEmployeeById(id);
    }
}
