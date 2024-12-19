package com.example.javafeatures.java8.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierStringFI {

    public static void main(String[] args) {

        Supplier<String[]> stringSupplier = () ->  new String[] {"regith","Ajith","rahul"};

        List<String> stringList = Arrays.asList(stringSupplier.get());

        stringList.stream().forEach(i -> System.out.println(i));
    }
}
