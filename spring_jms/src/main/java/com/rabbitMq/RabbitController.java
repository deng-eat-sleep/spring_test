package com.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rabbitMq")
public class RabbitController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @PostMapping("/msg")
    public String msg(@RequestBody String msg){
        rabbitMqService.sendMsg(msg);
        return "success";
    }
}
