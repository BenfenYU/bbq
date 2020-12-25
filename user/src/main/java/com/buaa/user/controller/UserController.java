package com.buaa.user.controller;

import com.buaa.user.common.BaseResult;
import com.buaa.user.model.User;
import com.buaa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    @RequestMapping(value = "/getById/{userId}")
    public String toLogin(@PathVariable String userId){
        return  "I am user-provider " + userId ;
    }

     */
    @RequestMapping(value = "/user/gateway",method = RequestMethod.GET)
    public String test(){
        return "I am user from gateway";
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    public BaseResult toLogin(String userAccount, String userPassword){
        return userService.toLogin(userAccount, userPassword);
    }

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
        System.out.println(userId);
        return userService.getUserByUserId(userId);
    }

}
