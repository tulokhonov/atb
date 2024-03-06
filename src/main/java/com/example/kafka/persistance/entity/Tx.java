package com.example.kafka.persistance.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Tx")
public class Tx {

    @Id
    private long transactionId;

    private String status;

    public Tx(long transactionId, String status) {
        this.transactionId = transactionId;
        this.status = status;
    }

    public Tx() {}

    public long getTransactionId() {
        return transactionId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Tx{" +
                "transactionId=" + transactionId +
                ", status='" + status + '\'' +
                '}';
    }
}
