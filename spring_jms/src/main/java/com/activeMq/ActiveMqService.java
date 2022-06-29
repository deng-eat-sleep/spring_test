package com.activeMq;

public interface ActiveMqService {

    void sendMsg(String msg);

    void receiveMsg(String msg);

}
