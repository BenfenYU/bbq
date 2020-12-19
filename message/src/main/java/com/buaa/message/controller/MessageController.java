package com.buaa.message.controller;

import com.buaa.message.common.BaseResult;
import com.buaa.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/message",method = RequestMethod.GET)
    public BaseResult getAllMessageOrderByDate(Integer offset, Integer limit){
        return messageService.getAllMessageOrderByDate(offset,limit);
    }

    @RequestMapping(value = "/single",method = RequestMethod.GET)
    public BaseResult getAMessageByMessageId(Integer messageId){
        return messageService.getAMessageByMessageId(messageId);
    }

    @RequestMapping(value = "/message",method = RequestMethod.POST)
    public BaseResult addMessage(Integer userId,String messageDetail){
        return messageService.addAMessage(userId,messageDetail);
    }

    @RequestMapping(value = "/messageimg",method = RequestMethod.POST)
    public BaseResult addMessageImageForMessage(@RequestParam(value = "file",required = false) MultipartFile file,
                                                @RequestParam("messageId") Integer messageId){
        return messageService.addMessageImageForMessage(messageId,file);
    }
}
