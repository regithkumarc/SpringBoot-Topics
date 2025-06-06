package com.example.annotations.bean;

public class BeanClass3 implements BeanInterface1 {

    @Override
    public void printMessage() {
        System.out.println("Printing the BeanClass3");
    }

    public void initMethod() {
        System.out.println("BeanClass3 Init method called");
    }

    public void destroyMethod() {
        System.out.println("BeanClass3 Destroy method called");
    }
}
