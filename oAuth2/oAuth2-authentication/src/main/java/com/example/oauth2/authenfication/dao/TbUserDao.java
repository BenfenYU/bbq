package com.example.oauth2.authenfication.dao;

import com.example.oauth2.authenfication.domain.TbUser;

public interface TbUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}