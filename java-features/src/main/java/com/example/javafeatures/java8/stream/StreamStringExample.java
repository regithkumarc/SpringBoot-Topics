package com.example.javafeatures.java8.stream;

import com.example.javafeatures.common.Employee;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStringExample {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("subin","regith","arun","anand","ajith","suresh");

        List<String> startsAtS = stringList.stream().filter(i -> i.startsWith("s")).collect(Collectors.toList());
        System.out.println("Starts At S : " + startsAtS);

        //AnyMatch
        boolean anyMatchS = stringList.stream().anyMatch(i -> i.startsWith("s"));
        System.out.println("Any Match S : " + anyMatchS);

        //AllMatch
        List<String> allMatchList = Arrays.asList("subih","suresh","jan");
        boolean allMatchStartWithSEndWithH = allMatchList.stream().allMatch(i -> i.startsWith("s") && i.endsWith("h"));
        System.out.println("All Match Suresh : " + allMatchStartWithSEndWithH);


        //Remove Duplicate
        List<String> stringDuplicateList = Arrays.asList("subin","regith","Subin","regITH","SUBin","RegitH");
        List<String> stringRemovedDuplicateList = stringDuplicateList.stream().distinct().collect(Collectors.toList());
        System.out.println("Removed Duplicate Data : " + stringRemovedDuplicateList);


        //Sorted
        List<Employee> employeeList = Arrays.asList(
                new Employee("ram","lead",23),
                new Employee("sam","developer",25),
                new Employee("gem","lead",28),
                new Employee("prem","manager",30),
                new Employee("ram","lead",25)
        );

        System.out.println("Filtered Lead Name................");
        employeeList.stream().filter(i -> i.getRole().equalsIgnoreCase("lead"))
                .forEach(i -> System.out.println(i.getName()));

        List<Employee> leadEmployeeList = employeeList.stream().filter(i -> i.getRole().equalsIgnoreCase("lead"))
                .collect(Collectors.toList());
        System.out.println("Lead Employee List : " + leadEmployeeList);

        List<Employee> leadEmployeeAgeSorting = employeeList.stream().filter(i -> i.getRole().equalsIgnoreCase("lead"))
                .sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("Lead Employee Age Sort List : " + leadEmployeeAgeSorting);

        employeeList.stream().collect(Collectors.groupingBy(Employee::getRole,Collectors.counting())).forEach((role, count) -> System.out.println(role + " : " + count));
    }
}
