package com.funtl.oauth2.resource.service;

import com.funtl.oauth2.common.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "message-consumer")
public interface MessageFeign {

    @RequestMapping(value = "/message/test",method = RequestMethod.GET)
    public String testMessage();

    @RequestMapping(value = "/message/message",method = RequestMethod.GET)
    public BaseResult getAllMessageOrderByDate(@RequestParam Integer offset, @RequestParam Integer limit);

    @RequestMapping(value = "/message/single",method = RequestMethod.GET)
    public BaseResult getAMessageByMessageId(Integer messageId);

    @RequestMapping(value = "/message/message",method = RequestMethod.POST)
    public BaseResult addMessage(@RequestParam Integer userId,@RequestParam String messageDetail);

    @RequestMapping(value = "/message/messageimg",method = RequestMethod.POST)
    public BaseResult addMessageImageForMessage(@RequestParam Integer messageId,@RequestParam MultipartFile file);
}
