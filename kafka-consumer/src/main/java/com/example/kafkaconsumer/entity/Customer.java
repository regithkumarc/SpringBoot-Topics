package com.example.kafkaconsumer.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    private int id;
    private String name;
}
