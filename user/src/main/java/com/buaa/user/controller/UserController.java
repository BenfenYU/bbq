package com.buaa.user.controller;

import com.buaa.user.common.BaseResult;
import com.buaa.user.model.User;
import com.buaa.user.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // ok
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "I am user";
    }

    // ok
    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    public BaseResult toLogin(String userAccount, String userPassword){
        return userService.toLogin(userAccount, userPassword);
    }

    // ok
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public BaseResult register(String userAccount,String userPassword,String userName,String userEmail){
        return userService.register(new User(userAccount,userPassword,userEmail,userName));
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public BaseResult getAlluser(Integer offset,Integer limit){
        return userService.getAllUser(offset,limit);
    }


    @RequestMapping(value = "/getById/{userId}",method = RequestMethod.GET)
    public User getAUser(@PathVariable("userId") Integer userId){
        // System.out.println(userId);
        return userService.getUserByUserId(userId);
    }

}
