package com.buaa.bbq.service;

import com.buaa.bbq.common.BaseResult;
import com.buaa.bbq.model.Bbqimage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BbqService {

    // String getAllBbqList();

    BaseResult getAllBbqOrderByDate(Integer offset, Integer limit);

    List<Bbqimage> getBbqImageListByBbqId(Integer bbqId);

    BaseResult getABbqByBbqId(Integer bbqId);

    BaseResult addBbqLike(Integer bbqId);

    BaseResult addBbqCommentLike(Integer bbqcommentId);

    BaseResult addABbqCommentForBbqId(Integer bbqId,Integer userId,String bbqcommentMessage);

    BaseResult addABbq(Integer userId,String bbqDetail);

    BaseResult addBbqImageForBbq(Integer bbqId, MultipartFile file);
}

