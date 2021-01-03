package com.example.oauth2client.controller;

import com.example.oauth2client.service.OAuth2ClientService;
import com.example.oauth2client.service.ToUserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    private OAuth2ClientService oAuth2ClientService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String test(){
        return oAuth2ClientService.test();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(String userAccount, String userPassword){
        return oAuth2ClientService.login(userAccount, userPassword);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(String userAccount,String userPassword,String userName,String userEmail){
        return oAuth2ClientService.register(userAccount,userPassword,userName,userEmail);
    }

}
