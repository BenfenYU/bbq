package com.example.oauth2client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "user-provider")
public interface ToUserConsumer {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    String test();

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    Object login(@RequestParam String userAccount,@RequestParam String userPassword);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    Object register(@RequestParam String userAccount,@RequestParam  String userPassword, @RequestParam String userName,@RequestParam  String userEmail);
}
