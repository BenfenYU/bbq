package com.example.oauth2client.service;

import com.example.oauth2client.common.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "message")
public interface ToMessageConsumer {


    // message

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String messageTest();

    @RequestMapping(value = "/message",method = RequestMethod.GET)
    public BaseResult getAllMessageOrderByDate(@RequestParam Integer offset, @RequestParam Integer limit);

    @RequestMapping(value = "/single",method = RequestMethod.GET)
    public BaseResult getAMessageByMessageId(Integer messageId);

    @RequestMapping(value = "/addmessage",method = RequestMethod.POST)
    public BaseResult addMessage(@RequestParam Integer userId,@RequestParam String messageDetail);

    @RequestMapping(value = "/messageimg",method = RequestMethod.POST)
    public BaseResult addMessageImageForMessage(@RequestParam Integer messageId,@RequestParam MultipartFile file);


}
