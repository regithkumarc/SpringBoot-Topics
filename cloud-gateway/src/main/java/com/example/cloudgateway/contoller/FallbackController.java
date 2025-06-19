package com.example.cloudgateway.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/order")
    public ResponseEntity<String> userServiceFallback() {
        return ResponseEntity.ok("Order Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/payment")
    public ResponseEntity<String> orderServiceFallback() {
        return ResponseEntity.ok("Payment Service is down. Please try again soon.");
    }

}
