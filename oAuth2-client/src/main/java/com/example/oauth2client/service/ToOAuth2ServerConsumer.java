package com.example.oauth2client.service;

import com.example.oauth2client.common.BaseResult;
import com.netflix.ribbon.proxy.annotation.Http;
import feign.Body;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "oauth2-server")
public interface ToOAuth2ServerConsumer {

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    BaseResult register(@RequestParam String userAccount, @RequestParam String userPassword, @RequestParam String userName, @RequestParam String userEmail);
}
