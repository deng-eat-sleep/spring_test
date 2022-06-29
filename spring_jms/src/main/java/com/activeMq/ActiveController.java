package com.activeMq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activeMq")
public class ActiveController {

    @Autowired
    private ActiveMqService activeMqService;

    @Value(value = "${server.port}")
    String port;

    @PostMapping("/msg")
    public String msg(@RequestBody String msg){
        activeMqService.sendMsg(msg);
        return "success";
    }
}
