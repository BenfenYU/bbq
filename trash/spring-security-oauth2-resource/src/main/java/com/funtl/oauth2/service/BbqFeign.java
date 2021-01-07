package com.funtl.oauth2.service;

import com.funtl.oauth2.common.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "bbq")
public interface BbqFeign {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String bbqTest();

    @RequestMapping(value = "/bbq",method = RequestMethod.GET)
    public BaseResult test(@RequestParam Integer offset, @RequestParam Integer limit);

    @RequestMapping(value = "/bbq/{bbqId}",method = RequestMethod.GET)
    public BaseResult getABbqByBbqId(@PathVariable("bbqId")Integer bbqId);

    @RequestMapping(value = "/bbqLike",method = RequestMethod.PUT)
    public BaseResult addBbqLike(Integer bbqId);

    @RequestMapping(value = "/bbqcommentLike",method = RequestMethod.PUT)
    public BaseResult addBbqCommentLike(Integer bbqcommentId);

    @RequestMapping(value = "/bbqcomment",method = RequestMethod.POST)
    public BaseResult addACommentForBbq(@RequestParam Integer bbqId,@RequestParam Integer userId,@RequestParam String bbqcommentMessage);

    @RequestMapping(value = "/bbq",method = RequestMethod.POST)
    public BaseResult addABbq(@RequestParam Integer userId,@RequestParam String bbqDetail);

    @RequestMapping(value = "/bbqimage",method = RequestMethod.POST)
    public BaseResult addBbqImageForBbq(@RequestParam MultipartFile file, @RequestParam Integer bbqId);
}
