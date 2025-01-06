package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.common.Utils;
import com.example.kafkaconsumer.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = Utils.MY_TOPIC1,groupId = Utils.GROUP_ID)
    public void consumeMessage(String message) {
        logger.info("Consumer consume the message {} ", message);
    }

    @KafkaListener(topics = Utils.MY_TOPIC1,groupId = Utils.GROUP_ID,containerFactory = "customerListener")
    public void consumeCustomer(Customer customer) {
        logger.info("Consumer consume the Customer {} ", customer);
    }
}
