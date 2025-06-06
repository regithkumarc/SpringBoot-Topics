package com.example.annotations.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimaryComponent1 implements PrimaryInterface1 {

    @Autowired
    private PrimaryInterface1 primaryInterface1;

    public void printMessage(){
        primaryInterface1.printMessage();
    }
}
