package com.funtl.oauth2.server.mapper;

import com.funtl.oauth2.server.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser> {

    int insertUser(@Param("username") String  username, @Param("password") String password,
                   @Param("phone") String phone, @Param("email") String email);

    int insertUserRole(@Param("user_id") Long userId);

    List<TbUser> selectByUserName(@Param("userName") String userName );

    String selectRoleByUserName(@Param("username") String username );

    int updateRoleByUserName(@Param("username") String username);
}