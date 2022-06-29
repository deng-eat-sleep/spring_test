package com.controller;

import com.entity.User;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id){
        System.out.println("-----id" + id);
        User user = new User();
        user.setId(id);
        return user;
    }

    @GetMapping("/timeOut/{name}")
    public String getUser(@PathVariable("name") String name){
        System.out.println(System.currentTimeMillis());
        System.out.println("-----name" + name);

        Long s = (long)(3000L*Math.random());
        System.out.println("------time:" + s);
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }
}
