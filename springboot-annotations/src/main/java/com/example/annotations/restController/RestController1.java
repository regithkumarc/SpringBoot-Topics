package com.example.annotations.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RestController1")
public class RestController1 {

    @GetMapping("/getName")
    public String getName() {
        return "Getting the RestController1";
    }
}
