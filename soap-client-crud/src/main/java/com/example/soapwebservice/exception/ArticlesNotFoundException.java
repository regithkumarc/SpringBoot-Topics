package com.example.soapwebservice.exception;

public class ArticlesNotFoundException extends RuntimeException {

    private String message;

    public ArticlesNotFoundException() {}

    public ArticlesNotFoundException(String message) {
        this.message = message;
    }
}
