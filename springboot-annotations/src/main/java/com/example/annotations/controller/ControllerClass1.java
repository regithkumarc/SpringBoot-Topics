package com.example.annotations.controller;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ControllerClass1")
public class ControllerClass1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/getName",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    private String getName() {
        return "Getting the ControllerClass1";
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/getName/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    private Employee getEmployeeById(@PathVariable int id) {
        return serviceClass1.getEmployeeById(id);
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/addEmployee",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    private Employee addEmployee(@RequestBody Employee employee) {
        return serviceClass1.addEmployee(employee);
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/updateEmployee",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    private Employee updateEmployee(@RequestBody Employee employee) {
        return serviceClass1.updateEmployee(employee);
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/deleteEmployeeById/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    private boolean deleteEmployeeById(@PathVariable int id) {
        return serviceClass1.deleteEmployeeById(id);
    }
}
