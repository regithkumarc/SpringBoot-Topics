package com.example.paymentservice.controller;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.exception.PaymentNotFoundException;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the PaymentController";
    }

    @GetMapping("/getPaymentById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) throws PaymentNotFoundException {
        Payment payment = paymentService.getPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping("/getAllPayments")
    public ResponseEntity<List<Payment>> getAllPayments() throws PaymentNotFoundException {
        List<Payment> paymentList = paymentService.getAllPayments();
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    @PostMapping("/createPayment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) throws PaymentNotFoundException {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PutMapping("/updatePayment")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment order) throws PaymentNotFoundException {
        Payment updatedPayment = paymentService.updatePayment(order);
        return new ResponseEntity<>(updatedPayment, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePaymentById/{id}")
    public ResponseEntity<Boolean> deletePaymentById(@PathVariable int id) throws PaymentNotFoundException {
        boolean deletedStatus = paymentService.deletePaymentById(id);
        return new ResponseEntity<>(deletedStatus,HttpStatus.OK);
    }
}
