package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.entity.Customer;
import com.example.kafkaproducer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/producer")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/getController")
    public String getController() {
        return "Getting the EventController class";
    }

    @GetMapping("/publishMessage/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            //kafkaMessagePublisher.sendMessage(message);
            return ResponseEntity.ok("Message Published Successfully");
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publishCustomerToTopic")
    public ResponseEntity<?> publishCustomerToTopic(@RequestBody Customer customer) {
        try {
            kafkaMessagePublisher.sendCustomerToTopic(customer);
            return ResponseEntity.ok("Customer Published Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
