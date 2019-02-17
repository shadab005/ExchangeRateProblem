package com.example.demo.job.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@Slf4j
public class ExchangeRateJobListener implements JobExecutionListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${erp.rabbitmq.exchange}")
    String exchange;

    @Value("${erp.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.exchange-rate}")
    String topic;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Exchange Rate Job initiated");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();
        String batchId = stepExecution.getExecutionContext().getString("batchId");

        log.info("Exchange Rate Job finished successfully with batch Id : " + batchId);
        //rabbitTemplate.convertAndSend(exchange, routingkey, "batchId:"+batchId);


        log.info("Exchange Rate Job finished successfully with batch Id : " + batchId);
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(topic, batchId);
        future.addCallback(result -> {
                    log.info("Successfully published to topic: " + topic +
                            " partition: " + result.getRecordMetadata().partition() +
                            " offset: " + result.getRecordMetadata().offset());
                }
                , ex -> {
                    log.error("Failed to publish to " + topic, ex);
                });

    }
}
