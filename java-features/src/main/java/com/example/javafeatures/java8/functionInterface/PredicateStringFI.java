package com.example.javafeatures.java8.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateStringFI {

    public static void main(String[] args) {

        Predicate<String> startWithS = (i) -> i.startsWith("s");

        Predicate<String> equals = (i) -> i.equals("bibin");

        Predicate<String> equalsIgnoreCase = (i) -> i.equalsIgnoreCase("bibin");

        Consumer<String> printString = (i) -> System.out.println(i);

        List<String> stringList = Arrays.asList("regith","vijay","sanjay","Bibin");
        stringList.stream().filter(startWithS).forEach(printString);

        stringList.stream().filter(equals).forEach(printString);

        stringList.stream().filter(equalsIgnoreCase).forEach(printString);
    }
}
