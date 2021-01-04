package com.example.oauth2client.service;

import com.example.oauth2client.common.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "oauth2-server")
public interface ToOAuth2ServerConsumer {

    @RequestMapping(value = "/oauth/authorize?client_id=client&response_type=code",method = RequestMethod.POST)
    BaseResult getOAuthCode(@RequestParam String userAccount, @RequestParam  String userPassword);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    BaseResult register(@RequestParam String userAccount, @RequestParam String userPassword, @RequestParam String userName, @RequestParam String userEmail);
}
