package com.example.javafeatures.java8.lamdaExpression;

@FunctionalInterface
public interface DisplayFI {

    void display(String message);

    static int display1(int i,int j) {
        return i+j;
    }

    default void displayMessage() {
        System.out.println("Message Displayed Successfully");
    }
}
