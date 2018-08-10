package com.example.demo.service;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.mapper.ExchangeRateMapper;
import com.example.demo.models.ExchangeRate2;
import com.example.demo.repositories.ExchangeRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By sudhanshu.singh on 8/11/18
 */

@Slf4j
@Service
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;
    private ExchangeRateMapper exchangeRateMapper;

    @Autowired
    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
    }

    public List<ExchangeRate2> saveExchangeRates(List<ExchangeRate2> exchangeRate2s) {

        return null;
    }

    public List<ExchangeRate2> saveExchangeRateEntities(List<ExchangeRateEntity> exchangeRateEntities) {

        return null;
    }

    public List<ExchangeRate2> findByBatchId(String batchId) {

        return null;
    }


}
