package com.buaa.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user-provider")
public interface LoginService {

    @RequestMapping(value = "/user/toLogin",method = RequestMethod.POST)
    Object login(@RequestParam String userAccount,@RequestParam String userPassword);

    @RequestMapping(value = "/user/user",method = RequestMethod.POST)
    Object register(@RequestParam String userAccount,@RequestParam String userPassword,@RequestParam String userName,@RequestParam String userEmail);
}
