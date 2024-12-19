package com.example.javafeatures.java8.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateIntegerFI {

    public static void main(String[] args) {

        //Predicate
        Predicate<Integer> lessThan10 = (i) -> i > 10;

        Predicate<Integer> evenNumber = (i) -> i%2 == 0;

        Predicate<Integer> oddNumber = (i) -> i%2 != 0;

        //Consumer
        Consumer<Integer> printInteger = (i) -> System.out.println(i);

        List<Integer> integerList = Arrays.asList(1,5,10,12,14,18,20);
        integerList.stream().filter(lessThan10).forEach(printInteger);

        //Even Number
        System.out.println("Even Number...............");
        integerList.stream().filter(evenNumber).forEach(printInteger);

        //Odd Number
        System.out.println("Odd Number.............");
        integerList.stream().filter(oddNumber).forEach(printInteger);

    }
}
