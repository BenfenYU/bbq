package com.buaa.user.service.impl;

import com.buaa.user.common.BaseResult;
import com.buaa.user.mapper.UserMapper;
import com.buaa.user.model.User;
import com.buaa.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public BaseResult toLogin(String userAccount, String userPassword) {
        BaseResult baseResult=new BaseResult();
        User user=userMapper.selectOne(new User(userAccount));
        if (null==user){
            baseResult.setO(404);
            baseResult.setMessage("该账户不存在，请注册");
            return baseResult;
        }
        if (user.getUserPassword().equals(userPassword)){
            baseResult.setStatus(200);
            baseResult.setMessage("登录成功");
            baseResult.setO(user);
        }else {
            baseResult.setStatus(500);
            baseResult.setMessage("密码错误，请重新输入");
        }
        return baseResult;
    }

    @Override
    public BaseResult register(User user) {
        BaseResult baseResult=new BaseResult();
        if (null==userMapper.selectOne(new User(user.getUserAccount()))){
            user.setUserDetail("普通用户");
            user.setUserUrl(":9011/img/logo.png");
            int insert = userMapper.insert(user);
            if (insert>0){
                baseResult.setStatus(200);
                baseResult.setMessage("注册成功");
            }else {
                baseResult.setStatus(404);
                baseResult.setMessage("注册失败");
            }
        }else {
            baseResult.setStatus(500);
            baseResult.setMessage("账号已存在");
        }
        return baseResult;
    }

    @Override
    public BaseResult getAllUser(Integer offset, Integer limit) {
        BaseResult baseResult=new BaseResult();
        PageHelper.startPage(offset,limit);
        List<User> users = userMapper.selectAll();
        PageInfo<User> pageInfo=new PageInfo<>(users);
        baseResult.setStatus(200);
        baseResult.setO(pageInfo);
        return baseResult;
    }


}
