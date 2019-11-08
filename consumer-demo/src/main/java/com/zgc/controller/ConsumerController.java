package com.zgc.controller;

import com.zgc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("{id}")
    public User queryById(@PathVariable("id") Integer id){
        String url = "http://localhost:8089/user/"+id;
        User user = restTemplate.getForObject(url,User.class);
        return user;
    }
}
