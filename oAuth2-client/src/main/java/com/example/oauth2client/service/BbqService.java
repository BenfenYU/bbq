package com.example.oauth2client.service;

import com.example.oauth2client.common.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "bbq-consumer")
public interface BbqService {

    @RequestMapping(value = "/bbq/test",method = RequestMethod.GET)
    public String bbqTest();

    @RequestMapping(value = "/bbq/bbq",method = RequestMethod.GET)
    public BaseResult test(@RequestParam Integer offset,@RequestParam Integer limit);

    @RequestMapping(value = "/bbq/bbq/{bbqId}",method = RequestMethod.GET)
    public BaseResult getABbqByBbqId(@PathVariable("bbqId")Integer bbqId);

    @RequestMapping(value = "/bbq/bbqLike",method = RequestMethod.PUT)
    public BaseResult addBbqLike(Integer bbqId);

    @RequestMapping(value = "/bbq/bbqcommentLike",method = RequestMethod.PUT)
    public BaseResult addBbqCommentLike(Integer bbqcommentId);

    @RequestMapping(value = "/bbq/bbqcomment",method = RequestMethod.POST)
    public BaseResult addACommentForBbq(@RequestParam Integer bbqId,@RequestParam Integer userId,@RequestParam String bbqcommentMessage);

    @RequestMapping(value = "/bbq/bbq",method = RequestMethod.POST)
    public BaseResult addABbq(@RequestParam Integer userId,@RequestParam String bbqDetail);

    @RequestMapping(value = "/bbq/bbqimage",method = RequestMethod.POST)
    public BaseResult addBbqImageForBbq(@RequestParam MultipartFile file,@RequestParam Integer bbqId);

}
