package com.rabbitMq;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName = null;


    @Value("${rabbitmq.queue.user}")
    private String userQueueName = null;

    @Bean
    public Queue createMsgQueue(){
        return new Queue(msgQueueName,true);
    }

    @Bean
    public Queue createUserQueue(){
        return new Queue(userQueueName,true);
    }
}
