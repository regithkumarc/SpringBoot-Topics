package com.example.droolsdemo.controller;

import com.example.droolsdemo.entity.Order;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private KieSession kieSession;

    @GetMapping
    public String getOrderController() {
        return "Getting the OrderController";
    }

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order) {
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;
    }
}
