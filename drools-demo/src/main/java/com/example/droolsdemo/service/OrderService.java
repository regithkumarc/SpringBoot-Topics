package com.example.droolsdemo.service;

import com.example.droolsdemo.entity.Order;
import com.example.droolsdemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Order addEmployee(Order order) {
        orderRepository.save(order);
        Optional<Order> optional = orderRepository.findById(order.getOrderId());
        return optional.orElse(null);
    }

    @Override
    public void updateEmployee(Order order) {
        Optional<Order> optional = orderRepository.findById(order.getOrderId());
        if (optional.isPresent()) {
            orderRepository.save(order);
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            orderRepository.deleteById(id);
        }
    }
}
