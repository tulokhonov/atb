package com.example.kafka.persistance.repository;

import com.example.kafka.persistance.entity.Tx;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxRepository extends CrudRepository<Tx, Long> {}
