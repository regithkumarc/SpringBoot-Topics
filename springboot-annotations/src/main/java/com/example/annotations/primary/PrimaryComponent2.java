package com.example.annotations.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
/*
 * Qualifier annotation is used in conjuction with Autowired to avoid confusion when we have two or more beans
 * configured for same type
 */
public class PrimaryComponent2 implements  PrimaryInterface1 {

    public void printMessage() {
        System.out.println("Print the PrimaryComponent2");
    }
}
