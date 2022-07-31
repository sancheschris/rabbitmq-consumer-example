package com.example.rabbitmqconsumerexample.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SimpleConsumer implements RabbitListenerConfigurer {

    @RabbitListener(queues = "${spring.rabbitmq.simpleQueue}")
    public void receivedMessage(String message) {
        log.info(String.format("Received message -> %s", message));
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
