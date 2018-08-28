package com.example.demo.writer;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ExchangeRateWriter implements ItemWriter<ExchangeRateEntity> {

    private ExchangeRateService exchangeRateService;

    @Override
    public void write(List<? extends ExchangeRateEntity> exchangeRateEntities){

        log.info("Writing to database successful");

    }

}
