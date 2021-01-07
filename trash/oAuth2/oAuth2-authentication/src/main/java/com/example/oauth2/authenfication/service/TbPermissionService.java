package com.example.oauth2.authenfication.service;

import com.example.oauth2.authenfication.domain.TbPermission;

import java.util.List;

public interface   TbPermissionService {

    List<TbPermission> selectByUserId(Long userId);
}
