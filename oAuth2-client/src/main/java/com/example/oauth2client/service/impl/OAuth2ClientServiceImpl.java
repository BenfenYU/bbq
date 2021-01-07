package com.example.oauth2client.service.impl;

import com.example.oauth2client.common.BaseResult;
import com.example.oauth2client.service.OAuth2ClientService;
import com.example.oauth2client.service.ServiceToUserOnly;
import com.example.oauth2client.service.ToOAuth2ServerConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuth2ClientServiceImpl implements OAuth2ClientService {


    // 用来找服务提供者

    @Autowired
    ToOAuth2ServerConsumer toOAuth2ServerConsumer;

    @Autowired
    ServiceToUserOnly serviceToUserOnly;

    @Override
    public BaseResult register(String userAccount, String userPassword, String userName, String userEmail) {
        BaseResult baseResult = new BaseResult();

        // 先向user的服务注册
        BaseResult baseResultUser = serviceToUserOnly.register(userAccount,userPassword,userName,userEmail);

        // 根据前者结果，向oauth2注册
        if (baseResultUser.getStatus() == 200) {
            BaseResult baseResultOauth = toOAuth2ServerConsumer.register(userAccount, userPassword, userName, userEmail);

            return baseResultOauth;
        }else{
            baseResultUser.setMessage("注册失败了，换个名字吧～");
            return baseResultUser;
        }

    }
}
