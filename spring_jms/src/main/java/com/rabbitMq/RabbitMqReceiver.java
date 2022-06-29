package com.rabbitMq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收器
 */
@Component
public class RabbitMqReceiver {

    @RabbitListener(queues = "${rabbitmq.queue.msg}")
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "${rabbitmq.queue.msg}",durable = "true"),
//            exchange = @Exchange(name = "msg-exchange",type = "topic"),
//            key = "msg.#"
//    ))
    public void receiveMsg(String msg){
        System.out.println("--------收到消息："+ msg);
    }
}
