package com.funtl.oauth2.server.service.impl;

import com.funtl.oauth2.common.BaseResult;
import com.funtl.oauth2.server.domain.TbPermission;
import com.funtl.oauth2.server.domain.TbRole;
import com.funtl.oauth2.server.domain.TbUser;
import com.funtl.oauth2.server.mapper.TbPermissionMapper;
import com.funtl.oauth2.server.mapper.TbRoleMapper;
import com.funtl.oauth2.server.mapper.TbUserMapper;
import com.funtl.oauth2.server.service.CommonService;
import com.funtl.oauth2.server.service.TbUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private TbUserService tbUserService;

    @Resource
    private TbUserMapper tbUserMapper;

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Resource
    private TbRoleMapper tbRoleMapper;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 这个注册是向数据库插入新的用户数据
    @Override
    public BaseResult register(String userAccount, String userPassword, String userName, String userEmail){
        TbUser tbUser = new TbUser();
        tbUser.setUsername(userAccount);
        tbUser.setPassword(passwordEncoder.encode( userPassword));
        tbUser.setEmail(userEmail);
        tbUser.setPhone(userEmail);
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        int insertSignal;
        BaseResult baseResult = new BaseResult();
        // 插入表tb_user
        insertSignal = tbUserMapper.insert(tbUser);
        if (insertSignal > 0){
            Long id = tbUser.getId();
            // 插入表tb_user_role
            insertSignal = tbUserMapper.insertUserRole(id);
            if (insertSignal > 0) {
                baseResult.setStatus(200);
                baseResult.setMessage("向oauth2-server注册成功！");
                return baseResult;
                }
            }
        baseResult.setMessage("向oauth2-server注册失败！");
        baseResult.setStatus(404);
        return baseResult;

//        insertSignal = tbUserService.insertUser(userAccount,userPassword,userName,userEmail);
    }

    @Override
    public BaseResult getPermissions(Integer offset,Integer limit) {
        BaseResult baseResult = new BaseResult();
        PageHelper.startPage(offset,limit);
        List<TbPermission> permissions= tbPermissionMapper.selectAll();
        PageInfo<TbPermission> pageInfo=new PageInfo<>(permissions);
        baseResult.setStatus(200);
        baseResult.setO(pageInfo);
        return baseResult;
    }

    @Override
    public BaseResult getRoles(Integer offset, Integer limit) {
        BaseResult baseResult = new BaseResult();
        PageHelper.startPage(offset,limit);
        List<TbRole> roles= tbRoleMapper.selectAllRoles();
        PageInfo<TbRole> pageInfo=new PageInfo<>(roles);
        baseResult.setStatus(200);
        baseResult.setO(pageInfo);

        return baseResult;
    }

    @Override
    public BaseResult whichRole(String userAccount) {
        BaseResult baseResult= new BaseResult();
        // 是否有此用户
        String role =  tbUserMapper.selectRoleByUserName(userAccount);
        baseResult.setMessage(role);
        baseResult.setStatus(200);
        return baseResult;
    }
    @Override
    public BaseResult updateRole(String userAccount) {
        BaseResult baseResult= new BaseResult();
        // 是否有此用户
        int signal =  tbUserMapper.updateRoleByUserName(userAccount);
        // baseResult.setMessage(role);
        if(signal == 1) {
            baseResult.setStatus(200);
        }else{
            baseResult.setStatus(500);
        }
        return baseResult;
    }
}
