package com.example.annotations.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanClass1 {

    @Autowired
    @Qualifier("beanClass2")
    private BeanInterface1 beanInterface1;

    public void printMessage() {
        beanInterface1.printMessage();
    }
}
