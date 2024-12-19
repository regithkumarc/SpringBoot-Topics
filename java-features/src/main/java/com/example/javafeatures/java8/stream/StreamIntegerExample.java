package com.example.javafeatures.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntegerExample {

    public static void main(String[] args) {


        List<Integer> integerList = Arrays.asList(1,2,3,4,10,11,6,5,7,9,8);

        // Even Number
        List<Integer> evenList = integerList.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers : " + evenList);

        // Odd Number
        List<Integer> oddList = integerList.stream().filter(i -> i%2 != 0).collect(Collectors.toList());
        System.out.println("Odd List : " + oddList);

        //Max
        Integer max= integerList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Max : " + max);

        Integer max1 = integerList.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
        System.out.println("Max 1 : " + max1);

        // First Max
        Integer firstMax = integerList.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("First Max : " + firstMax);

        //Second Max
        Integer secondMax = integerList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Second Max : " + secondMax);


        // Min
        Integer min = integerList.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Min : " + min);

        //First Min
        Integer firstMin = integerList.stream().sorted(Comparator.naturalOrder()).findFirst().get();
        System.out.println("First Min : " + firstMin);

        //SecondMin
        Integer secondMin = integerList.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
        System.out.println("Second Min : " + secondMin);

        // Remove duplicate
        List<Integer> integerDuplicateList = Arrays.asList(1,2,3,4,5,2,3);
        List<Integer> integerRemovedDuplicateList = integerDuplicateList.stream().distinct().collect(Collectors.toList());
        System.out.println("Removed Duplicate Data : " + integerRemovedDuplicateList);
    }
}
