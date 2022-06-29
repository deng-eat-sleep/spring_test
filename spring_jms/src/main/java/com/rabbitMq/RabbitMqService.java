package com.rabbitMq;

import com.entity.User;

public interface RabbitMqService {

    void sendMsg(String msg);

    void sendUser(User user);
}
