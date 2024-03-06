package com.example.kafka.service;

import com.example.kafka.persistance.entity.Tx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTestProducer {

    private final Logger logger = LoggerFactory.getLogger(KafkaTestProducer.class);

    private final KafkaTemplate<String, Tx> kafkaTemplate;

    public KafkaTestProducer(KafkaTemplate<String, Tx> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Tx transaction){
        logger.info("Sending: {}", transaction);

        kafkaTemplate.send("txTopic", String.valueOf(transaction.getTransactionId()), transaction);
    }
}