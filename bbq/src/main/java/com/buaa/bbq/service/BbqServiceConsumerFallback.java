package com.buaa.bbq.service;

import com.buaa.bbq.model.User;
import org.springframework.stereotype.Component;


// 提供熔断，如果服务提供者挂掉，返回null
@Component
public class BbqServiceConsumerFallback implements BbqServiceConsumer {

    @Override
    public User getById(Integer userId) {
        User user = null;
        return user;
    }
}
