package com.example.annotations.lazy;

public class LazyClass3 implements LazyInterface1 {

    @Override
    public void printMessage() {
        System.out.println("Printing the lazyClass3");
    }

    public void initMethod() {
        System.out.println("lazyClass3 Init method called");
    }

    public void destroyMethod() {
        System.out.println("lazyClass3 Destroy method called");
    }
}
