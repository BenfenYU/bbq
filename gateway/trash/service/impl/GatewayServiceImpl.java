package com.buaa.gateway.service.impl;

import com.buaa.gateway.service.GatewayService;
import com.buaa.gateway.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayServiceImpl implements GatewayService {
    @Autowired
    LoginService loginService;

    public Object login(String userAccount, String userPassword){
        return loginService.login( userAccount,  userPassword);
    }

    public Object register(String userAccount,String userPassword,String userName,String userEmail){
        return loginService.register( userAccount, userPassword, userName, userEmail);
    }
}
