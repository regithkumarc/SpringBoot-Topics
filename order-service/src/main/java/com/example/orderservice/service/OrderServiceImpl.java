package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.model.TransactionRequest;
import com.example.orderservice.model.TransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OrderServiceImpl {

    Order getOrderById(int id) throws OrderNotFoundException;
    List<Order> getAllOrders();
    TransactionResponse createOrder(TransactionRequest transactionRequest) throws JsonProcessingException;
    Order updateOrder(Order order);
    boolean deleteOrderById(int id) throws OrderNotFoundException;
}
