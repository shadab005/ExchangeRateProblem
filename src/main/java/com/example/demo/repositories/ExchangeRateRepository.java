package com.example.demo.repositories;

import com.example.demo.entity.ExchangeRateEntity;

import java.util.List;

public interface ExchangeRateRepository {

    List<ExchangeRateEntity> findByBatchId(String batchId);
}
