package com.buaa.gateway.service;

public interface GatewayService {
    Object login(String userAccount, String userPassword);

    Object register(String userAccount,String userPassword,String userName,String userEmail);
}
