package com.example.demo.processor;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.mapper.ExchangeRateMapper;
import com.example.demo.models.ExchangeRate2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ExchangeRateEventProcessor implements ItemProcessor<ExchangeRate2, ExchangeRateEntity> {

    private ExchangeRateMapper exchangeRateMapper;

    @Autowired
    public ExchangeRateEventProcessor(ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateMapper = exchangeRateMapper;
    }

    @Override
    public ExchangeRateEntity process(final ExchangeRate2 exchangeRate2) throws Exception {
        final ExchangeRateEntity exchangeRateEntity = exchangeRateMapper.convertToEntity(exchangeRate2);
        //put batch id and kd
        log.info("Converting (" + exchangeRate2 + ") into (" + exchangeRateEntity + ")");
        return exchangeRateEntity;
    }

}
