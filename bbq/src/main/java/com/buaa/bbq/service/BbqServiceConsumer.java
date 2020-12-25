package com.buaa.bbq.service;
import com.buaa.bbq.common.BaseResult;
import com.buaa.bbq.model.Bbqimage;
import com.buaa.bbq.model.User;
import com.buaa.bbq.service.impl.BbqServiceConsumerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(value = "user-provider",fallback = BbqServiceConsumerFallback.class)
public interface BbqServiceConsumer {
    /*
    @GetMapping(value = "/user/getById/{userId}")
    String getById(@PathVariable("userId") String userId);
     */
    @GetMapping(value = "/user/getById/{userId}")
    User getById(@PathVariable("userId") Integer userId);
}