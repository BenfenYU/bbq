package com.buaa.bbq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.buaa.bbq.mapper")
@EnableDiscoveryClient\
@EnableFeignClients
public class BbqApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbqApplication.class, args);
    }

}
