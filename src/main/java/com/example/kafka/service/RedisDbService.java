package com.example.kafka.service;

import com.example.kafka.persistance.entity.Tx;
import com.example.kafka.persistance.repository.TxRepository;
import org.springframework.stereotype.Service;

@Service
public class RedisDbService implements DbService {

    private final TxRepository txRepository;

    public RedisDbService(TxRepository txRepository) {
        this.txRepository = txRepository;
    }

    @Override
    public void save(Tx tx) {
        txRepository.save(tx);
    }
}
