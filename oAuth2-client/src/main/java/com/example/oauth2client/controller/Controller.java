package com.example.oauth2client.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.oauth2client.common.BaseResult;
import com.example.oauth2client.service.BbqService;
import com.example.oauth2client.service.MessageService;
import com.example.oauth2client.service.OAuth2ClientService;
import com.example.oauth2client.service.ToUserService;
import okhttp3.*;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    private OAuth2ClientService oAuth2ClientService;

    @Autowired
    private ToUserService toUserService;

    @Autowired
    private BbqService bbqService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult login(String userAccount, String userPassword) throws IOException {
        BaseResult baseResult = new BaseResult();
        String token = getToken(userAccount,userPassword);
        System.out.println(String.format("token: %s", token));
        if (token == null){
            baseResult.setStatus(500);
            return baseResult;
        }else{
            baseResult.setMessage(token);
            return baseResult;
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(String userAccount,String userPassword,String userName,String userEmail){
        return oAuth2ClientService.register(userAccount,userPassword,userName,userEmail);
    }

    // 到user的

    @RequestMapping(value = "/user/test",method = RequestMethod.GET)
    public String userTest(){
        return toUserService.userTest();
    }

    @RequestMapping(value = "/user/user",method = RequestMethod.GET)
    public BaseResult getAlluser(@RequestParam Integer offset,@RequestParam Integer limit){
        return toUserService.getAlluser(offset,limit);
    }


    @RequestMapping(value = "/user/getById/{userId}",method = RequestMethod.GET)
    public Object getAUser(@PathVariable("userId") Integer userId){
        // System.out.println(userId);
        return toUserService.getAUser(userId);
    }

    // 到bbq的
    @RequestMapping(value = "/bbq/test",method = RequestMethod.GET)
    public String bbqTest(){
        return bbqService.bbqTest();
    }

    @RequestMapping(value = "/bbq/bbq",method = RequestMethod.GET)
    public BaseResult test(Integer offset, Integer limit){
        return bbqService.test(offset,limit);
    }

    @RequestMapping(value = "/bbq/bbq",method = RequestMethod.POST)
    public BaseResult addABbq(Integer userId,String bbqDetail){
        return bbqService.addABbq(userId,bbqDetail);
    }

    @RequestMapping(value = "/bbq/bbq/{bbqId}",method = RequestMethod.GET)
    public BaseResult getABbqByBbqId(@PathVariable("bbqId")Integer bbqId){
        return bbqService.getABbqByBbqId(bbqId);
    }

    @RequestMapping(value = "/bbq/bbqLike",method = RequestMethod.PUT)
    public BaseResult addBbqLike(Integer bbqId){
        return bbqService.addBbqLike(bbqId);
    }

    @RequestMapping(value = "/bbq/bbqcommentLike",method = RequestMethod.PUT)
    public BaseResult addBbqCommentLike(Integer bbqcommentId){
        return bbqService.addBbqCommentLike(bbqcommentId);
    }

    @RequestMapping(value = "/bbq/bbqcomment",method = RequestMethod.POST)
    public BaseResult addACommentForBbq(Integer bbqId,Integer userId,String bbqcommentMessage){
        return bbqService.addACommentForBbq(bbqId,userId,bbqcommentMessage);
    }

    @RequestMapping(value = "/bbq/bbqimage",method = RequestMethod.POST)
    public BaseResult addBbqImageForBbq(@RequestParam(value = "file",required = false) MultipartFile file,
                                        @RequestParam("bbqId") Integer bbqId){
        return bbqService.addBbqImageForBbq(file,bbqId);
    }

    // 到message的
    @RequestMapping(value = "/message/test",method = RequestMethod.GET)
    public String test(){
        return messageService.test();
    }

    @RequestMapping(value = "/message/message",method = RequestMethod.GET)
    public BaseResult getAllMessageOrderByDate(@RequestParam Integer offset,@RequestParam Integer limit){
        return messageService.getAllMessageOrderByDate(offset,limit);
    }

    @RequestMapping(value = "/message/single",method = RequestMethod.GET)
    public BaseResult getAMessageByMessageId(Integer messageId){
        return messageService.getAMessageByMessageId(messageId);
    }

    @RequestMapping(value = "/message/message",method = RequestMethod.POST)
    public BaseResult addMessage(@RequestParam Integer userId,@RequestParam String messageDetail){
        return messageService.addMessage(userId,messageDetail);
    }

    @RequestMapping(value = "/message/messageimg",method = RequestMethod.POST)
    public BaseResult addMessageImageForMessage(@RequestParam(value = "file",required = false) MultipartFile file,
                                                @RequestParam("messageId") Integer messageId){
        return messageService.addMessageImageForMessage(messageId,file);
    }

    public String getToken(String username,String password) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody b = RequestBody.create(mediaType,
                String.format("username=%s&password=%s&grant_type=password&client_id=client&client_secret=123456", username,password));
        Request request = new Request.Builder()
                .url("http://localhost:10020/oauth/token")
                .method("POST", b)
                .addHeader("Authorization", "Basic Y2xpZW50OjEyMzQ1Ng==")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "JSESSIONID=7E61266231BC3DF3261CE52EB38B5E79")
                .build();
        Response r = client.newCall(request).execute();
        JSONObject jsonObject = JSONObject.parseObject(r.body().string());
        String token = (String)jsonObject.get("access_token");

        return token;
    }
}
