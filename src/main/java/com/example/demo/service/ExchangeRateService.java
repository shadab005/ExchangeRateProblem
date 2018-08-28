package com.example.demo.service;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.mapper.ExchangeRateMapper;
import com.example.demo.models.ExchangeRateInfo;
import com.example.demo.repositories.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By sudhanshu.singh on 8/11/18
 */

@Service
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;
    private ExchangeRateMapper exchangeRateMapper;

    public List<ExchangeRateInfo> saveExchangeRates(List<ExchangeRateInfo> exchangeRateInfos) {

        return null;
    }

    public List<ExchangeRateInfo> saveExchangeRateEntities(List<ExchangeRateEntity> exchangeRateEntities) {

        return null;
    }

    public List<ExchangeRateInfo> findByBatchId(String batchId) {

        return null;
    }


}
