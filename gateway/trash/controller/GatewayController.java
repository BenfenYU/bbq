package com.buaa.gateway.controller;

import com.buaa.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String returnHello(){
        return "hello, I am gateway";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(String userAccount,String userPassword,String userName,String userEmail){
        return gatewayService.register(userAccount,userPassword,userName,userEmail);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(String userAccount, String userPassword){
        return gatewayService.login(userAccount,userPassword);
    }
}
