package com.example.orderservice.service;

import com.example.orderservice.common.URL;
import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.model.Payment;
import com.example.orderservice.model.TransactionRequest;
import com.example.orderservice.model.TransactionResponse;
import com.example.orderservice.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RefreshScope
@Slf4j
public class OrderService implements OrderServiceImpl {

/*    @Value("${microservices.payment-service.endpoints.endpoint.uri}")
    private String paymentServiceBaseURL;*/

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    @Lazy
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
    public TransactionResponse createOrder(TransactionRequest transactionRequest) throws JsonProcessingException {

        Order order = transactionRequest.getOrder();
        order.setId(UUID.randomUUID().variant());
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        log.info("Order Service Request : {} ",new ObjectMapper().writeValueAsString(transactionRequest));

        Payment paymentResponse = restTemplate.postForObject(URL.PAYMENT_BASE_URL + "/createPayment",payment, Payment.class);
        String response = paymentResponse.getStatus().equals("success") ? "Payment processing successful and order placed" : "Failure in payment API and order added to cart";

        log.info("Order Service with Payment Response : {} ",new ObjectMapper().writeValueAsString(paymentResponse));
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
