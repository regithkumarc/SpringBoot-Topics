package com.example.soapwebservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String name;
    private String role;

    public Employees() {}

    public Employees(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee Id : " + employeeId + " : Name : " + name + " : Role : " + role;
    }
}
