package com.example.demo.job.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExchangeRateJobListener implements JobExecutionListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${erp.rabbitmq.exchange}")
    String exchange;

    @Value("${erp.rabbitmq.routingkey}")
    private String routingkey;


    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Exchange Rate Job initiated");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();
        String batchId = stepExecution.getExecutionContext().getString("batchId");
        log.info("Exchange Rate Job finished successfully with batch Id : " + batchId);
        rabbitTemplate.convertAndSend(exchange, routingkey, "batchId:"+batchId);
    }
}
