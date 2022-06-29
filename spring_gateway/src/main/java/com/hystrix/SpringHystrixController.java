package com.hystrix;

import com.feign.user.UserFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断路器 hystrix
 */
@RestController
@RequestMapping("/hystrix")
public class SpringHystrixController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/test/{name}")
    @HystrixCommand(fallbackMethod = "error")
    public String timeOut(@PathVariable("name") String name){
        return userFeign.timeOut(name);
    }

    public String error(String name){
        return "超时响应";
    }
}
