package com.example.productbasic.feign;

import com.example.productbasic.feign.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userbasic", fallback = UserServiceHystrix.class)
public interface UserService {

    @GetMapping("user/{id}")
    public Object getUser(@PathVariable("id") Long id);

    @GetMapping("user/timeOut")
    public Object timeOut();
}
