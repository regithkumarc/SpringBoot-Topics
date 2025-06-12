package com.example.orderservice.model;

import com.example.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionRequest {

    Order order;
    Payment payment;
}
