package com.example.kafka.service;

import com.example.kafka.persistance.entity.Tx;

public interface DbService {

    /**
     * Сохраняет транзакцию в БД
     * @param tx транзакция
     */
    void save(Tx tx);
}
