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

    @RequestMapping(value = "/getPermissions",method = RequestMethod.GET)
    public BaseResult getPermissions(Integer offset,Integer limit){

        return commonService.getPermissions( offset, limit);
    }
    @RequestMapping(value = "/getRoles",method = RequestMethod.GET)
    public BaseResult getRoles(Integer offset,Integer limit){

        return commonService.getRoles( offset, limit);
    }

    @RequestMapping(value = "/whichRole",method = RequestMethod.GET)
    public BaseResult whichRole(String userAccount){

        return commonService.whichRole( userAccount);
    }
    @RequestMapping(value = "/updateRole",method = RequestMethod.GET)
    public BaseResult updateRole(String userAccount){

        return commonService.updateRole( userAccount);
    }
}

