package com.example.oauth2.authenfication.mapper;

import com.example.oauth2.authenfication.domain.TbUser;
import tk.mybatis.mapper.MyMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.entity.Example;

/**
 * 自己的 Mapper
 * 特别注意，该接口不能被扫描到，否则会出错
 * <p>Title: MyMapper</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/5/29 0:57
 */
public interface TbUserMapper<T> extends MyMapper<TbUser> {
}
