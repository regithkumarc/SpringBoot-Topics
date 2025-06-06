package com.example.annotations.qualifier;

import org.springframework.stereotype.Component;

@Component("qualifierComponent2")
public class QualifierComponent2 implements QualifierInterface1 {

    public void printMessage() {
        System.out.println("print the QualifierComponent2");
    }
}
