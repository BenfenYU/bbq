package com.example.oauth2.authenfication.service.impl;

import com.example.oauth2.authenfication.domain.TbUser;
import com.example.oauth2.authenfication.mapper.TbUserMapper;
import com.example.oauth2.authenfication.service.TbUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username",username);
        return (TbUser) tbUserMapper.selectOneByExample(example);
    }
}
