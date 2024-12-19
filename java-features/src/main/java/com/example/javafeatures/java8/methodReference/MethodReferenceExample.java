package com.example.javafeatures.java8.methodReference;

public class MethodReferenceExample {

    MethodReferenceExample(){}

    MethodReferenceExample(String message) {
        System.out.println(message);
    }

    public static void display() {
        System.out.println("Static display method is working");
    }

    public void display1(){
        System.out.println("Display 1 method is working");
    }

    public static void main(String[] args) {
        DisplayMR displayMR = MethodReferenceExample::display;
        displayMR.display();

        DisplayMR displayMR1 = new MethodReferenceExample() ::display1;
        displayMR1.display();

        ConstructorMR constructorMR = MethodReferenceExample::new;
        constructorMR.getMethodReferenceExample("Constructor Created for MethodReferenceExample");

    }
}
