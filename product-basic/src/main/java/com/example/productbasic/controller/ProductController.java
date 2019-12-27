package com.example.productbasic.controller;

import com.example.productbasic.feign.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;


    @GetMapping("/testRibbon")
    public Object testRibbon() {
        Object object = null;
        for (int i = 0; i < 10; i++) {
            object = userService.getUser(Long.valueOf(i));
        }
        return object;
    }

    @GetMapping("/timeOut")
    public Object timeOut() {
        Object object = null;
        for (int i = 0; i < 10; i++) {
            object = userService.timeOut();
        }
        return object;
    }
}
