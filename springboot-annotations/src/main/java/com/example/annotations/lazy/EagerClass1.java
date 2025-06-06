package com.example.annotations.lazy;

import org.springframework.stereotype.Component;

@Component
public class EagerClass1 {

    public EagerClass1() {
        System.out.println("Printing the EagerClass1 Constructor");
    }

    public void printMessage() {
        System.out.println("Printing the EagerClass1");
    }
}
