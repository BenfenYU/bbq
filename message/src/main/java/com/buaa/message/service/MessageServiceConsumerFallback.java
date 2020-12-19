package com.buaa.message.service;

import com.buaa.message.model.User;
import org.springframework.stereotype.Component;


// 提供熔断，如果服务提供者挂掉，返回null
@Component
public class MessageServiceConsumerFallback implements MessageConsumerService {

    @Override
    public User getById(Integer userId) {
        User user = null;
        return user;
    }
}
