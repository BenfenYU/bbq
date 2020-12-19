package com.buaa.bbq.controller;

import com.buaa.bbq.common.BaseResult;
import com.buaa.bbq.service.BbqService;
import com.buaa.bbq.service.BbqServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("bbq")
public class BbqController {

    @Autowired
    private BbqService bbqService;


    @RequestMapping(value = "/bbq",method = RequestMethod.GET)
    public BaseResult getAllBbqList(Integer offset, Integer limit){
        return bbqService.getAllBbqOrderByDate(offset,limit);
    }


    /*
    @RequestMapping(value = "/bbq/hi",method = RequestMethod.GET)
    public String getAllBbqList(){

        return bbqService.getAllBbqList();
    }

     */

    @RequestMapping(value = "/bbq/{bbqId}",method = RequestMethod.GET)
    public BaseResult getABbqByBbqId(@PathVariable("bbqId")Integer bbqId){
        return bbqService.getABbqByBbqId(bbqId);
    }

    @RequestMapping(value = "/bbqLike",method = RequestMethod.PUT)
    public BaseResult addBbqLike(Integer bbqId){
        return bbqService.addBbqLike(bbqId);
    }

    @RequestMapping(value = "/bbqcommentLike",method = RequestMethod.PUT)
    public BaseResult addBbqCommentLike(Integer bbqcommentId){
        return bbqService.addBbqCommentLike(bbqcommentId);
    }

    @RequestMapping(value = "/bbqcomment",method = RequestMethod.POST)
    public BaseResult addACommentForBbq(Integer bbqId,Integer userId,String bbqcommentMessage){
        return bbqService.addABbqCommentForBbqId(bbqId,userId,bbqcommentMessage);
    }

    @RequestMapping(value = "/bbq",method = RequestMethod.POST)
    public BaseResult addABbq(Integer userId,String bbqDetail){
        return bbqService.addABbq(userId,bbqDetail);
    }

    @RequestMapping(value = "/bbqimage",method = RequestMethod.POST)
    public BaseResult addBbqImageForBbq(@RequestParam(value = "file",required = false) MultipartFile file,
                                        @RequestParam("bbqId") Integer bbqId){
        return bbqService.addBbqImageForBbq(bbqId,file);
    }
}
