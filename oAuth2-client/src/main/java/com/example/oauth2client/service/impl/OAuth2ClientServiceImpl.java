package com.example.oauth2client.service.impl;

import com.example.oauth2client.common.BaseResult;
import com.example.oauth2client.service.OAuth2ClientService;
import com.example.oauth2client.service.ToOAuth2ServerConsumer;
import com.example.oauth2client.service.ToUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuth2ClientServiceImpl implements OAuth2ClientService {


    // 用来找服务提供者
    @Autowired
    ToUserService toUserService;

    @Autowired
    ToOAuth2ServerConsumer toOAuth2ServerConsumer;

    @Override
    public BaseResult login(String userAccount, String userPassword) {
        System.out.println("访问到oauth-client，开始访问oauth2-server");
        Object object = toOAuth2ServerConsumer.getOAuthCode(userAccount,userPassword);
        System.out.println(object);

        return toUserService.toLogin(userAccount,userPassword);
    }

    @Override
    public BaseResult register(String userAccount, String userPassword, String userName, String userEmail) {
        BaseResult baseResult = new BaseResult();

        // 先向user的服务注册
        BaseResult baseResultUser = toUserService.register(userAccount,userPassword,userName,userEmail);

        // 根据前者结果，向oauth2注册
        if (baseResultUser.getStatus() == 102){
            BaseResult baseResultOauth = toOAuth2ServerConsumer.register(userAccount,userPassword,userName,userEmail);
            if (baseResultOauth.getStatus() == 104){
                baseResult.setStatus(100);
            }else{
                baseResult.setStatus(105);
            }
        }else{
            baseResult.setStatus(103);
        }

        return baseResult;
    }
}
