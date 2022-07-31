package com.example.rabbitmqconsumerexample.service;

import com.example.rabbitmqconsumerexample.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RabbitMqConsumer implements RabbitListenerConfigurer {

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(User user) {

        log.info("User Details Received is.. " + user);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
