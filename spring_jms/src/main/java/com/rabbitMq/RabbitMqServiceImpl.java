package com.rabbitMq;

import com.entity.User;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service("rabbitMqService")
public class RabbitMqServiceImpl implements RabbitTemplate.ConfirmCallback,RabbitMqService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.msg}")
    private String msgRouting = null;

    @Value("${rabbitmq.queue.user}")
    private String userRouting = null;

    @Override
    public void sendMsg(String msg) {
        System.out.println("--------发送消息：" + msg);
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(msgRouting,msg);
    }

    @Override
    public void sendUser(User user) {
        System.out.println("--------发送消息：" + user);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack){
            System.out.println("--------消息成功消费");
        }else{
            System.out.println("--------消息消费失败：" + cause);
        }
    }
}
