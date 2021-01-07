package com.funtl.oauth2.server.service.impl;

import com.funtl.oauth2.server.domain.TbUser;
import com.funtl.oauth2.server.mapper.TbUserMapper;
import com.funtl.oauth2.server.service.TbUserService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
        example.createCriteria().andEqualTo("username", username);
        return tbUserMapper.selectOneByExample(example);
    }

    @Override
    public int insertUser(String userAccount, String userPassword, String userName, String userEmail) {
        // tbUserMapper.insertUser(userAccount, userPassword, userName, userEmail);
        int signal;
        signal = tbUserMapper.insertUser(userAccount, userPassword, userName, userEmail);

        return signal;
    }
}
