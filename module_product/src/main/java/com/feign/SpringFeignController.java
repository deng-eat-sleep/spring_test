package com.feign;

import com.entity.User;
import com.feign.user.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class SpringFeignController {

    @Autowired
    private UserFeign userFeign;

    @PostMapping("/feign")
    public User testRibbon(@RequestBody String test){
        User user = null;
        for(int i = 1; i <= 10;i++){
            user = userFeign.getUser(Long.valueOf(i));
        }
        return user;
    }
}
