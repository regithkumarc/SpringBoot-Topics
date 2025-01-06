package com.example.kafkaproducer.service;

import com.example.kafkaproducer.common.Utils;
import com.example.kafkaproducer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    public KafkaTemplate<String,Customer> kafkaTemplate;

/*    public void sendMessage(String message) {
       CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send(Utils.MY_TOPIC1,message);

        future.whenComplete(((stringObjectSendResult, throwable) -> {
            if(throwable == null) {
                System.out.println("Send Message = [" + message + "] with offset= ["
                        + stringObjectSendResult.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send Message = [" + message + "] due to : " + throwable.getMessage());
            }
        }));
    }*/

    public void sendCustomerToTopic(Customer customer) {
        CompletableFuture<SendResult<String,Customer>> future = kafkaTemplate.send(Utils.MY_TOPIC1,customer);

        System.out.println("published");
        future.whenComplete(((stringObjectSendResult, throwable) -> {
            if(throwable == null) {
                System.out.println("Send customer to topic = [" + customer + "] with offset= ["
                        + stringObjectSendResult.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send customer to topic = [" + customer + "] due to : " + throwable.getMessage());
            }
        }));
    }

}
