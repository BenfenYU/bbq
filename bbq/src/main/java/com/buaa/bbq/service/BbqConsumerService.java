package com.buaa.bbq.service;
import com.buaa.bbq.model.User;
import com.buaa.bbq.service.fallback.BbqServiceConsumerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-provider",fallback = BbqServiceConsumerFallback.classva)
public interface BbqConsumerService {
    /*
    @GetMapping(value = "/user/getById/{userId}")
    String getById(@PathVariable("userId") String userId);
     */

    @GetMapping(value = "/user/getById/{userId}")
    User getById(@PathVariable("userId") Integer userId);
}