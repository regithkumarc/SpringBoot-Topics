package com.example.orderservice.exception;

public class OrderNotFoundException extends  Exception {

    public OrderNotFoundException(String message) {
        super(message);
    }
}
