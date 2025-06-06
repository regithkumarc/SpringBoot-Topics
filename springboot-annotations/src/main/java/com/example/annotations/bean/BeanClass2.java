package com.example.annotations.bean;

public class BeanClass2 implements BeanInterface1 {

    @Override
    public void printMessage() {
        System.out.println("Printing the BeanClass2");
    }

    public void initMethod() {
        System.out.println("BeanClass2 Init method called");
    }

    public void destroyMethod() {
        System.out.println("BeanClass2 Destroy method called");
    }
}
