package com.example.centralizedlog.service;

import com.example.centralizedlog.entity.Payment;
import com.example.centralizedlog.exception.PaymentNotFoundException;
import com.example.centralizedlog.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService implements PaymentServiceImpl {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getPaymentById(int id) throws PaymentNotFoundException {
        Optional<Payment> optional = paymentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new PaymentNotFoundException("Payment not found this id : " + id);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setStatus("success");
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public boolean deletePaymentById(int id) throws PaymentNotFoundException {
        Optional<Payment> optional = paymentRepository.findById(id);
        if(optional.isPresent()) {
            paymentRepository.deleteById(id);
            return true;
        } else {
            throw new PaymentNotFoundException("Payment not found this id : " + id);
        }
    }
}
