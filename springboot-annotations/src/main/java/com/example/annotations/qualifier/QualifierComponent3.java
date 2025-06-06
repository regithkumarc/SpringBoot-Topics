package com.example.annotations.qualifier;

import org.springframework.stereotype.Component;

@Component("qualifierComponent3")
public class QualifierComponent3 implements QualifierInterface1 {

    public void printMessage() {
        System.out.println("print the QualifierComponent3");
    }
}
