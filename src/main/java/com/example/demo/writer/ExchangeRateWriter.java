package com.example.demo.writer;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ExchangeRateWriter implements ItemWriter<ExchangeRateEntity> {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Override
    public void write(List<? extends ExchangeRateEntity> exchangeRateEntities) throws Exception {
        //exchangeRateService.saveExchangeRateEntities(exchangeRateEntities);

    }

}
