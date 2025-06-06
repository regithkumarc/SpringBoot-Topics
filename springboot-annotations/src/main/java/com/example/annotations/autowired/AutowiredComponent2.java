package com.example.annotations.autowired;

import org.springframework.stereotype.Component;

@Component
public class AutowiredComponent2 {

    public void printName(){
        System.out.println("Printing the AutowiredComponent2");
    }
}
