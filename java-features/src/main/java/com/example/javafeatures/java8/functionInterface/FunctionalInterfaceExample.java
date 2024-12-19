package com.example.javafeatures.java8.functionInterface;


import com.example.javafeatures.common.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        Function<String,Character> firstChar = (name) -> name.charAt(0);

        Function<String,String> employeeFunction = (name) -> name;

        Consumer<Character> printCharacter = (i) -> System.out.println(i);

        Consumer<String> printString = (i) -> System.out.println(i);

        List<String> stringList = Arrays.asList("regith","Anoop","Sathish","Kumar");

        System.out.println("Print Char..............");
        stringList.stream().map(firstChar).forEach(printCharacter);

        System.out.println("Print Employee Name..............");
        stringList.stream().map(employeeFunction).forEach(printString);
    }
}
