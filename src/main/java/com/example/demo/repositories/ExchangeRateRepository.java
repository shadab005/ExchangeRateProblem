package com.example.demo.repositories;

import com.example.demo.entity.ExchangeRateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRateEntity, Long> {

    List<ExchangeRateEntity> findByBatchId(String batchId);
}
