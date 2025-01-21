package com.example.droolsdemo.service;

import com.example.droolsdemo.entity.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order addEmployee(Order order);
    void updateEmployee(Order order);
    void deleteOrderById(Long id);
}
