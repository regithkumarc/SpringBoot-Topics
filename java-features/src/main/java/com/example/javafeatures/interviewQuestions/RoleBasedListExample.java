package com.example.javafeatures.interviewQuestions;

import com.example.javafeatures.common.Employee;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RoleBasedListExample {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("ram","lead",20));
        employeeList.add(new Employee("sam","developer",23));
        employeeList.add(new Employee("gem","lead",28));
        employeeList.add(new Employee("prem","manager",30));

        Map<String,Long> counted = employeeList.stream().collect(Collectors.groupingBy(Employee::getRole,Collectors.counting()));
        System.out.println(counted);
    }
}
