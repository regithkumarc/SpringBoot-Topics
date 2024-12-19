package com.example.javafeatures.java8.lamdaExpression;

@FunctionalInterface
public interface AddFI {

    void add(int i,int j);

    static int add1(int i,int j) {
        return i+j;
    }

    default void addMessage() {
        System.out.println("Message Added Successfully");
    }
}
