package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.model.TransactionRequest;
import com.example.orderservice.model.TransactionResponse;
import com.example.orderservice.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getName")
    public String getName() {
        log.info("getName is calling");
        return "Getting the OrderController";
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) throws OrderNotFoundException {
        Order order = orderService.getOrderById(id);
        log.info("getOrderById : {} {} ",id,order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException {
        List<Order> orderList = orderService.getAllOrders();
        log.info("getAllOrders : {}",orderList);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<TransactionResponse> createOrder(@RequestBody TransactionRequest transactionRequest) throws OrderNotFoundException, JsonProcessingException {
        TransactionResponse transactionResponse = orderService.createOrder(transactionRequest);
        log.info("createOrder response : {}",transactionResponse);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws OrderNotFoundException {
        Order updatedOrder = orderService.updateOrder(order);
        log.info("updateOrder response : {}",updatedOrder);
        return new ResponseEntity<>(updatedOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<Boolean> deleteOrderById(@PathVariable int id) throws OrderNotFoundException {
        boolean deletedStatus = orderService.deleteOrderById(id);
        log.info("deleteOrderById : {}",deletedStatus);
        return new ResponseEntity<>(deletedStatus,HttpStatus.OK);
    }
}
