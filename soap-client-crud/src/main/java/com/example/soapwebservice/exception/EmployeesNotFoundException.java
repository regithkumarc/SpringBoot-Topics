package com.example.soapwebservice.exception;

public class EmployeesNotFoundException extends RuntimeException {

    private String message;

    public EmployeesNotFoundException() {}

    public EmployeesNotFoundException(String message) {
        this.message = message;
    }
}
