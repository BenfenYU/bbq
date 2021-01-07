package com.funtl.oauth2.server.controller;

import com.funtl.oauth2.common.BaseResult;
import com.funtl.oauth2.server.service.CommonService;
import com.funtl.oauth2.server.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2ServerController {
    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public BaseResult register(String userAccount, String userPassword, String userName, String userEmail){

        return commonService.register(userAccount,userPassword,userName,userEmail);
    }
}
