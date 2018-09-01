package com.example.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExchangeRateMessageHandler {

    @RabbitListener(queues = "${erp.rabbitmq.queue}")
    public void processOrder(String message) {
        log.info("Message received for batch: "+ message);
    }
}
