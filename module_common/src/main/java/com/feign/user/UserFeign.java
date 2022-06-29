package com.feign.user;

import com.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user")
public interface UserFeign {

    @GetMapping("/user/getUser/{id}")
    User getUser(@PathVariable("id") Long id);

    @GetMapping("/user/timeOut/{name}")
    String timeOut(@PathVariable("name") String name);
}
