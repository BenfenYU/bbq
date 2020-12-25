package com.buaa.message.service;

import com.buaa.message.model.User;
import com.buaa.message.service.impl.MessageServiceConsumerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "user-provider",fallback = MessageServiceConsumerFallback.class)
public interface MessageConsumerService {
    /*
    @GetMapping(value = "/user/getById/{userId}")
    String getById(@PathVariable("userId") String userId);
     */
    @GetMapping(value = "/user/getById/{userId}")
    User getById(@PathVariable("userId") Integer userId);
}