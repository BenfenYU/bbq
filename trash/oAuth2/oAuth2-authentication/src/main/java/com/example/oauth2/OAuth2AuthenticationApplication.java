package com.example.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAuthorizationServer
@MapperScan(basePackages = "com.example.oauth2.authenfication.mapper")
public class OAuth2AuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2AuthenticationApplication.class,args);
    }
}
