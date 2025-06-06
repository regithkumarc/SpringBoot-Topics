package com.example.annotations.lazy;

public class LazyClass2 implements LazyInterface1 {

    @Override
    public void printMessage() {
        System.out.println("Printing the lazyClass2");
    }

    public void initMethod() {
        System.out.println("lazyClass2 Init method called");
    }

    public void destroyMethod() {
        System.out.println("lazyClass2 Destroy method called");
    }
}
