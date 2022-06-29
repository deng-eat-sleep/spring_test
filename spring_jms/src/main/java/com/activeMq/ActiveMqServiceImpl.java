package com.activeMq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class ActiveMqServiceImpl implements ActiveMqService{

    @Autowired
    private JmsTemplate jmsTemplate = null;

    @Autowired
    private Queue queue;

    @Override
    public void sendMsg(String msg) {
        System.out.println("------------发送消息：" + msg);

        jmsTemplate.convertAndSend(queue,msg);

    }

    @JmsListener(destination = "msgQueue")
    @Override
    public void receiveMsg(String msg) {
        System.out.println("------------接收消息：" + msg);
    }
}
