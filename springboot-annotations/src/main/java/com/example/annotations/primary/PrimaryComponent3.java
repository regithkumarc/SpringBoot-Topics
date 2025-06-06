package com.example.annotations.primary;

import org.springframework.stereotype.Component;

@Component
public class PrimaryComponent3 implements  PrimaryInterface1 {

    @Override
    public void printMessage() {
        System.out.println("Print the PrimaryComponent3");
    }
}
