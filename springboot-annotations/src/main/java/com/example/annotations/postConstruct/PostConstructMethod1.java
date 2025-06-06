package com.example.annotations.postConstruct;

import com.example.annotations.model.Employee;
import com.example.annotations.service.ServiceClass1;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PostConstructMethod1")
public class PostConstructMethod1 {

    @Autowired
    private ServiceClass1 serviceClass1;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the PostConstructMethod1";
    }

    @PostConstruct
    public void printMessage() {
        System.out.println("Calling the PostConstruct PostConstructMethod1 ");
    }
}
