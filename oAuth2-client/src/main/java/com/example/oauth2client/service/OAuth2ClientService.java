package com.example.oauth2client.service;

public interface OAuth2ClientService {

    public String test();

    public Object login(String userAccount, String userPassword);

    public Object register(String userAccount,String userPassword,String userName,String userEmail);
}
