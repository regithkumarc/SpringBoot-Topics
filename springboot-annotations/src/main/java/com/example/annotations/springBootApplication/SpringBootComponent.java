package com.example.annotations.springBootApplication;

import org.springframework.stereotype.Component;

@Component("springbootComp")
public class SpringBootComponent {

    public void printName() {
        System.out.println("Printing the SpringBootComponent");
    }
}
