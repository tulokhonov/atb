package com.example.kafka.listener;

import com.example.kafka.persistance.entity.Tx;
import com.example.kafka.service.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TxListener {

    private final Logger logger = LoggerFactory.getLogger(TxListener.class);

    private final DbService dbService;

    public TxListener(DbService dbService) {
        this.dbService = dbService;
    }

    @KafkaListener(topics = "txTopic")
    public void getTx(Tx transaction) {
        logger.info("Got: {}", transaction);
        dbService.save(transaction);
    }
}
