package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.model.TransactionRequest;
import com.example.orderservice.model.TransactionResponse;

import java.util.List;

public interface OrderServiceImpl {

    Order getOrderById(int id) throws OrderNotFoundException;
    List<Order> getAllOrders();
    TransactionResponse createOrder(TransactionRequest transactionRequest);
    Order updateOrder(Order order);
    boolean deleteOrderById(int id) throws OrderNotFoundException;
}
