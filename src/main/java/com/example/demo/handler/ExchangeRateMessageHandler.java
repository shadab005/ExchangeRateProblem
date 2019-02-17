package com.example.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ExchangeRateMessageHandler {

    //@RabbitListener(queues = "${erp.rabbitmq.queue}")
    public void processOrder(String message) {
        log.info("RMQ Message received for batch: "+ message);
    }

    @KafkaListener(topics = "exchange-rate", groupId = "exchange_rate_group")
    public void consume(String message) throws IOException {
        log.info("Kafka Message received for batch: "+ message);
    }

}