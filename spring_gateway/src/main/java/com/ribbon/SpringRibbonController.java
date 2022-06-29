package com.ribbon;

import com.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ri
 */

@RestController
@RequestMapping("/product")
public class SpringRibbonController {

//    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public User testRibbon(){
        User user = null;
        for(int i = 1; i <= 10;i++){
            restTemplate.getForObject("http://USER/user/getUser" + i,User.class);
        }
        return user;
    }

}
