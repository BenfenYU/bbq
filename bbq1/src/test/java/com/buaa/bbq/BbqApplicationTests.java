package com.buaa.bbq;

import com.buaa.bbq.model.Notice;
import com.buaa.bbq.model.User;
import com.buaa.bbq.service.BbqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BbqApplicationTests {

    @Autowired
    BbqService bbqService;

    @Test
    void contextLoads() {
        System.out.println(bbqService.getAllBbqOrderByDate(1,10));
    }

}
