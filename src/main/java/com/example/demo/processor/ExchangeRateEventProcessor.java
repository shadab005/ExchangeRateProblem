package com.example.demo.processor;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.mapper.ExchangeRateMapper;
import com.example.demo.models.ExchangeRateInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExchangeRateEventProcessor implements ItemProcessor<ExchangeRateInfo, ExchangeRateEntity> {

    private ExchangeRateMapper exchangeRateMapper;

    @Autowired
    public ExchangeRateEventProcessor(ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateMapper = exchangeRateMapper;
    }

    @Override
    public ExchangeRateEntity process(final ExchangeRateInfo exchangeRateInfo) {
        final ExchangeRateEntity exchangeRateEntity = exchangeRateMapper.convertToEntity(exchangeRateInfo);
        //put batch id and kd
        log.info("Converting (" + exchangeRateInfo + ") into (" + exchangeRateEntity + ")");
        return exchangeRateEntity;
    }

}
