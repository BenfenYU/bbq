package com.example.oauth2.authenfication.service;

import com.example.oauth2.authenfication.domain.TbUser;

public interface TbUserService {
    TbUser getByUsername(String username);
}
