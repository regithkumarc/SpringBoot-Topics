package com.example.paymentservice.service;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.exception.PaymentNotFoundException;

import java.util.List;

public interface PaymentServiceImpl {

    Payment getPaymentById(int id) throws PaymentNotFoundException;
    List<Payment> getAllPayments();
    Payment createPayment(Payment payment);
    Payment updatePayment(Payment payment);
    boolean deletePaymentById(int id) throws PaymentNotFoundException;
}
