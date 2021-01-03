package com.buaa.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-provider")
public interface RegisterService {

    @PostMapping(value = "/user/user")
    Object register(String userAccount,String userPassword,String userName,String userEmail);
}
