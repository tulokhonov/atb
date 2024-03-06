package com.example.kafka;

import com.example.kafka.persistance.entity.Tx;
import com.example.kafka.persistance.repository.TxRepository;
import com.example.kafka.service.KafkaTestProducer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
public class ManualTests {

    private final Logger logger = LoggerFactory.getLogger(KafkaApplicationTests.class);

    @Autowired
    private TxRepository txRepository;

    @Autowired
    private KafkaTestProducer kafkaTestProducer;

    @Test
    void test1() {
        txRepository.save(new Tx(1, "WAIT"));
        txRepository.save(new Tx(1, "DONE"));
        txRepository.save(new Tx(1, "OK"));
        txRepository.save(new Tx(2, "OK"));
    }

    @Test
    void test2() {
        Iterable<Tx> txIterable = txRepository.findAll();
        for (Tx tx: txIterable) {
            logger.info(tx.toString());
        }
    }

    @Test
    void test3() {
        kafkaTestProducer.sendMessage(new Tx(1L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(1L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(1L, "COMMIT"));
        kafkaTestProducer.sendMessage(new Tx(2L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(2L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(2L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(2L, "COMMIT"));
        kafkaTestProducer.sendMessage(new Tx(3L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(3L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(3L, "WAIT"));
        kafkaTestProducer.sendMessage(new Tx(3L, "COMMIT"));
    }
}
