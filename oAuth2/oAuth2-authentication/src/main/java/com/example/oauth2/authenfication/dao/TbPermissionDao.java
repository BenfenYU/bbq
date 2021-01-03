package com.example.oauth2.authenfication.dao;

import com.example.oauth2.authenfication.domain.TbPermission;

public interface TbPermissionDao {

    int deleteByPrimaryKey(Long id);

    int insert(TbPermission record);

    int insertSelective(TbPermission record);

    TbPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbPermission record);

    int updateByPrimaryKey(TbPermission record);
}