package com.example.centralizedlog.service;

import com.example.centralizedlog.entity.Payment;
import com.example.centralizedlog.exception.PaymentNotFoundException;

import java.util.List;

public interface PaymentServiceImpl {

    Payment getPaymentById(int id) throws PaymentNotFoundException;
    List<Payment> getAllPayments();
    Payment createPayment(Payment payment);
    Payment updatePayment(Payment payment);
    boolean deletePaymentById(int id) throws PaymentNotFoundException;
}
