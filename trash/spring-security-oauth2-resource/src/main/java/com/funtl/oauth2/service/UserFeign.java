package com.funtl.oauth2.service;

import com.funtl.oauth2.common.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user")
public interface UserFeign {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String userTest();

    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    public BaseResult toLogin(@RequestParam String userAccount, @RequestParam String userPassword);

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public BaseResult register(@RequestParam String userAccount,@RequestParam String userPassword,@RequestParam String userName,@RequestParam String userEmail);

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public BaseResult getAlluser(@RequestParam Integer offset,@RequestParam Integer limit);

    @RequestMapping(value = "/getById/{userId}",method = RequestMethod.GET)
    public Object getAUser(@PathVariable("userId") Integer userId);
}
