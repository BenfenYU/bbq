package com.buaa.user.service;


import com.buaa.user.common.BaseResult;
import com.buaa.user.model.User;

public interface UserService {

    User getUserByUserId(Integer userId);

    BaseResult toLogin(String userAccount,String userPassword);

    BaseResult register(User user);

    BaseResult getAllUser(Integer offset,Integer limit);
}
