package com.example.annotations.queryParam;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/QueryParamInput1")
public class QueryParamInput1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the QueryParamInput1";
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestParam(value = "name",required = false) String name,
                                @RequestParam(value = "salary",required = false) int salary) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        return serviceClass1.addEmployee(employee);
    }
}
