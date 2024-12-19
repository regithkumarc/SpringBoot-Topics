package com.example.javafeatures.common;

import lombok.NoArgsConstructor;
import lombok.ToString;

public class Employee {
    private String name;
    private String role;
    private int age;

    public Employee(String name,String role,int age) {
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name : " + name + " <-> Role : " + role + " <-> Age : " + age;
    }
}
