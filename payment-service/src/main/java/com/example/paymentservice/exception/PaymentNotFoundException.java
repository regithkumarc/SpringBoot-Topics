package com.example.paymentservice.exception;

public class PaymentNotFoundException extends  Exception {

    public PaymentNotFoundException(String message) {
        super(message);
    }
}
