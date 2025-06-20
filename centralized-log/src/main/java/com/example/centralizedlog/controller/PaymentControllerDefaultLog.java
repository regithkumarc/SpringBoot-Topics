package com.example.centralizedlog.controller;

import com.example.centralizedlog.entity.Payment;
import com.example.centralizedlog.exception.PaymentNotFoundException;
import com.example.centralizedlog.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentDefaultLog")
@Slf4j
public class PaymentControllerDefaultLog {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the PaymentControllerDefaultLog";
    }

    @GetMapping("/getPaymentById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) throws PaymentNotFoundException {
        Payment payment = paymentService.getPaymentById(id);
        log.info("getPaymentById : {} " , payment);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping("/getAllPayments")
    public ResponseEntity<List<Payment>> getAllPayments() throws PaymentNotFoundException {
        List<Payment> paymentList = paymentService.getAllPayments();
        log.info("getAllPayments : {} " , paymentList);
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    @PostMapping("/createPayment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) throws PaymentNotFoundException {
        Payment createdPayment = paymentService.createPayment(payment);
        log.info("createPayment : {} " , createdPayment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PutMapping("/updatePayment")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment order) throws PaymentNotFoundException {
        Payment updatedPayment = paymentService.updatePayment(order);
        log.info("updatePayment : {} " , updatedPayment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePaymentById/{id}")
    public ResponseEntity<Boolean> deletePaymentById(@PathVariable int id) throws PaymentNotFoundException {
        boolean deletedStatus = paymentService.deletePaymentById(id);
        log.info("deletePaymentById : {} " , deletedStatus);
        return new ResponseEntity<>(deletedStatus,HttpStatus.OK);
    }
}
