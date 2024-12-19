package com.example.javafeatures.java8.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFI {

    public static void main(String[] args) {

        System.out.println("Without Consume...............");
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.stream().forEach(i -> System.out.println(i));

        // Consumer
        System.out.println("with Consumer..............");
        Consumer<Integer> integerConsumer = (i) -> System.out.println(i);
        integerList.stream().forEach(integerConsumer);

    }
}
