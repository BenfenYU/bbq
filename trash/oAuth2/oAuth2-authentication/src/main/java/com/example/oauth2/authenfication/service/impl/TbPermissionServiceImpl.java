package com.example.oauth2.authenfication.service.impl;

import com.example.oauth2.authenfication.domain.TbPermission;
import com.example.oauth2.authenfication.mapper.TbPermissionMapper;
import com.example.oauth2.authenfication.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
