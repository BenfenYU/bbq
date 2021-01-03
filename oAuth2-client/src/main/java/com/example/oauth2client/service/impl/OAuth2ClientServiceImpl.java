package com.example.oauth2client.service.impl;

import com.example.oauth2client.service.OAuth2ClientService;
import com.example.oauth2client.service.ToUserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuth2ClientServiceImpl implements OAuth2ClientService {


    // 用来找服务提供者
    @Autowired
    ToUserConsumer toUserConsumer;

    @Override
    public String test(){
        return toUserConsumer.test();
    }

    @Override
    public Object login(String userAccount, String userPassword) {
        return toUserConsumer.login(userAccount,userPassword);
    }

    @Override
    public Object register(String userAccount, String userPassword, String userName, String userEmail) {
        return toUserConsumer.register(userAccount,userPassword,userName,userEmail);
    }
}
