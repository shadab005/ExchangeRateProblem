package com.example.demo.job.step;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.mapper.ExchangeRateMapper;
import com.example.demo.models.ExchangeRateInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ExchangeRateEventProcessor implements ItemProcessor<ExchangeRateInfo, ExchangeRateEntity> {

    private ExchangeRateMapper exchangeRateMapper;

    @Autowired
    public ExchangeRateEventProcessor(ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateMapper = exchangeRateMapper;
    }

    private String batchId;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution){
        UUID uuid = UUID.randomUUID();
        batchId = uuid.toString();
        stepExecution.getExecutionContext().putString("batchId", batchId);
    }

    @Override
    public ExchangeRateEntity process(final ExchangeRateInfo exchangeRateInfo) {
        final ExchangeRateEntity exchangeRateEntity = exchangeRateMapper.convertToEntity(exchangeRateInfo, batchId);
        //put batch id and kd
        log.info("Converting (" + exchangeRateInfo + ") into (" + exchangeRateEntity + ")");
        return exchangeRateEntity;
    }

}
