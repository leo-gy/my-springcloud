package com.example.userbasic.controller;

import com.example.userbasic.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        ServiceInstance serviceInstance = discoveryClient.getInstances("USERBASIC").get(0);
        log.info(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        User user=new User();
        user.setId(Long.valueOf(1));
        user.setLevel(1);
        user.setNote(""+System.currentTimeMillis());
        user.setUserName("aaa");
        return user;
    }
    @GetMapping("timeOut")
    public User timeOut(){
        User user=new User();
        long magnification= RandomUtils.nextInt(3);
        user.setId(magnification);
        try {
            Thread.sleep(magnification*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
