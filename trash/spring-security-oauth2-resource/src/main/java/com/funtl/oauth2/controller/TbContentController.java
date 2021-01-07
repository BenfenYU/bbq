package com.funtl.oauth2.controller;
import com.funtl.oauth2.common.BaseResult;
import com.funtl.oauth2.service.BbqFeign;
import com.funtl.oauth2.service.MessageFeign;
import com.funtl.oauth2.service.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TbContentController {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private BbqFeign bbqFeign;

    @Autowired
    private MessageFeign messageFeign;

    @GetMapping("/")
    public String testResource() {
        return "oauth2 resource";
    }

    // 下面是需要权限的接口
    // user
//    @RequestMapping(value = "/user/test",method = RequestMethod.GET)
//    public String userTest(){
//        return userFeign.userTest();
//    }
//
//    @RequestMapping(value = "/user/toLogin", method = RequestMethod.POST)
//    public BaseResult toLogin(@RequestParam String userAccount, @RequestParam String userPassword) {
//        return userFeign.toLogin(userAccount,userPassword);
//    }
//
//    @RequestMapping(value = "/user/user", method = RequestMethod.POST)
//    public BaseResult register(@RequestParam String userAccount, @RequestParam String userPassword, @RequestParam String userName, @RequestParam String userEmail) {
//        return userFeign.register(userAccount,userPassword,userName,userEmail);
//    }

    @RequestMapping(value = "/user/user", method = RequestMethod.GET)
    public BaseResult getAlluser(@RequestParam Integer offset, @RequestParam Integer limit) {
        return userFeign.getAlluser(offset,limit);
    }

    @RequestMapping(value = "/user/getById/{userId}", method = RequestMethod.GET)
    public Object getAUser(@PathVariable("userId") Integer userId) {
        return userFeign.getAUser(userId);
    }

    //bbq
    @RequestMapping(value = "/bbq/test", method = RequestMethod.GET)
    public String bbqTest() {
        return bbqFeign.bbqTest();
    }

    @RequestMapping(value = "/bbq/bbq", method = RequestMethod.GET)
    public BaseResult test(@RequestParam Integer offset, @RequestParam Integer limit) {
        return bbqFeign.test(offset,limit);
    }

    @RequestMapping(value = "/bbq/bbq/{bbqId}", method = RequestMethod.GET)
    public BaseResult getABbqByBbqId(@PathVariable("bbqId") Integer bbqId) {
        return bbqFeign.getABbqByBbqId(bbqId);
    }

    @RequestMapping(value = "/bbq/bbqLike", method = RequestMethod.PUT)
    public BaseResult addBbqLike(Integer bbqId) {
        return bbqFeign.addBbqLike(bbqId);
    }

    @RequestMapping(value = "/bbq/bbqcommentLike", method = RequestMethod.PUT)
    public BaseResult addBbqCommentLike(Integer bbqcommentId) {
        return bbqFeign.addBbqCommentLike(bbqcommentId);
    }

    @RequestMapping(value = "/bbq/bbqcomment", method = RequestMethod.POST)
    public BaseResult addACommentForBbq(@RequestParam Integer bbqId, @RequestParam Integer userId, @RequestParam String bbqcommentMessage) {
        return bbqFeign.addACommentForBbq(bbqId, userId, bbqcommentMessage);
    }

    @RequestMapping(value = "/bbq/bbq", method = RequestMethod.POST)
    public BaseResult addABbq(@RequestParam Integer userId, @RequestParam String bbqDetail) {
        return bbqFeign.addABbq(userId, bbqDetail);
    }

    @RequestMapping(value = "/bbq/bbqimage", method = RequestMethod.POST)
    public BaseResult addBbqImageForBbq(@RequestParam MultipartFile file, @RequestParam Integer bbqId) {
        return bbqFeign.addBbqImageForBbq(file,bbqId);
    }

    // message
    @RequestMapping(value = "/message/test", method = RequestMethod.GET)
    public String testMessage() {
        return messageFeign.testMessage();
    }

    @RequestMapping(value = "/message/message", method = RequestMethod.GET)
    public BaseResult getAllMessageOrderByDate(@RequestParam Integer offset, @RequestParam Integer limit) {
        return messageFeign.getAllMessageOrderByDate(offset, limit);
    }

    @RequestMapping(value = "/message/single", method = RequestMethod.GET)
    public BaseResult getAMessageByMessageId(Integer messageId) {
        return messageFeign.getAMessageByMessageId(messageId);
    }

    @RequestMapping(value = "/message/addmessage", method = RequestMethod.POST)
    public BaseResult addMessage(@RequestParam Integer userId, @RequestParam String messageDetail) {
        return messageFeign.addMessage(userId,messageDetail);
    }

    @RequestMapping(value = "/message/messageimg", method = RequestMethod.POST)
    public BaseResult addMessageImageForMessage(@RequestParam Integer messageId, @RequestParam MultipartFile file) {
        return messageFeign.addMessageImageForMessage(messageId, file);
    }
}
