package com.example.productbasic.feign.hystrix;

import com.example.productbasic.feign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceHystrix implements UserService {

    @Override
    public Object getUser(Long id) {
        log.error("************************getUser********************");
        return null;
    }

    @Override
    public Object timeOut() {
        log.error("************************timeOut********************");
        return null;
    }
}
