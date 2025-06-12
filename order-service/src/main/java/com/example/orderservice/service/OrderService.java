package com.example.orderservice.service;

import com.example.orderservice.common.URL;
import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.model.Payment;
import com.example.orderservice.model.TransactionRequest;
import com.example.orderservice.model.TransactionResponse;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService implements OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order getOrderById(int id) throws OrderNotFoundException {
        Optional<Order> optional = orderRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new OrderNotFoundException("Order not found this id : " + id);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public TransactionResponse createOrder(TransactionRequest transactionRequest) {

        Order order = transactionRequest.getOrder();
        order.setId(UUID.randomUUID().variant());
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject(URL.PAYMENT_BASE_URL + "/createPayment",payment, Payment.class);
        String response = paymentResponse.getStatus().equals("success") ? "Payment processing successful and order placed" : "Failure in payment API and order added to cart";
        orderRepository.save(order);

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setOrder(order);
        transactionResponse.setAmount(paymentResponse.getAmount());
        transactionResponse.setTransactionId(paymentResponse.getTransactionId());
        transactionResponse.setResponse(response);

        return transactionResponse;
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrderById(int id) throws OrderNotFoundException {
        Optional<Order> optional = orderRepository.findById(id);
        if(optional.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        } else {
            throw new OrderNotFoundException("Order not found this id : " + id);
        }
    }
}
