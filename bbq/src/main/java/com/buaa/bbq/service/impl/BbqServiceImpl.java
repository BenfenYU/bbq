package com.buaa.bbq.service.impl;

import com.buaa.bbq.common.BaseResult;
import com.buaa.bbq.mapper.*;
import com.buaa.bbq.model.*;
import com.buaa.bbq.service.BbqService;
import com.buaa.bbq.service.BbqServiceConsumer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class BbqServiceImpl implements BbqService {

    // 用来找服务提供者
    @Autowired
    BbqServiceConsumer bbqServiceConsumer;

    /*
    public String getAllBbqList(){

        return bbqServiceConsumer.getById("czd"); //"I am bbq consumer";//
    }

     */

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @Autowired
    private BbqimageMapper bbqimageMapper;

    @Autowired
    private BbqMapper bbqMapper;

    @Autowired
    private BbqcommentMapper bbqcommentMapper;

    //private final String userUri="http://localhost:9001/user/getById/{userId}";

    @Override
    public BaseResult getAllBbqOrderByDate(Integer offset, Integer limit) {
        RestTemplate restTemplate=new RestTemplate();
        PageHelper.startPage(offset,limit);
        Example example=new Example(Bbq.class);
        example.setOrderByClause("bbq_date desc");
        List<Bbq> bbqs = bbqMapper.selectByExample(example);
        PageInfo<Bbq> pageInfo=new PageInfo<>(bbqs);
        List<BbqUser> list=new ArrayList<>();
        for (Bbq bbq : pageInfo.getList()) {
            BbqUser bbqUser=new BbqUser();
            bbqUser.setBbqDate(bbq.getBbqDate());
            bbqUser.setBbqId(bbq.getBbqId());
            bbqUser.setBbqLike(bbq.getBbqLike());
            bbqUser.setBbqMessage(bbq.getBbqMessage());

            // User user = restTemplate.getForObject(userUri, User.class, bbq.getUserId());
            // 调用服务提供者
            User user = bbqServiceConsumer.getById(bbq.getUserId());

            bbqUser.setUser(user);
            bbqUser.setImages(getBbqImageListByBbqId(bbq.getBbqId()));
            bbqUser.setComments(getTwoBbqCommentOrderByLike(bbq.getBbqId()));
            list.add(bbqUser);
        }
        BaseResult baseResult=new BaseResult();
        baseResult.setStatus((int) pageInfo.getTotal());
        baseResult.setO(list);
        System.out.println(list);
        return baseResult;
    }

    public List<BbqcommentUser> getTwoBbqCommentOrderByLike(Integer bbqId){
        RestTemplate restTemplate=new RestTemplate();
        PageHelper.startPage(1,2);
        Example example=new Example(Bbqcomment.class);
        example.setOrderByClause("bbqcomment_like desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bbqId",bbqId);
        List<Bbqcomment> bbqcomments = bbqcommentMapper.selectByExample(example);
        PageInfo<Bbqcomment> pageInfo=new PageInfo<>(bbqcomments);
        return getBbqcommentUsers(restTemplate, pageInfo.getList());
    }

    private List<BbqcommentUser> getBbqcommentUsers(RestTemplate restTemplate, List<Bbqcomment> bbqcomments) {
        List<BbqcommentUser> list=new ArrayList<>();
        for (Bbqcomment bbqcomment : bbqcomments) {
            BbqcommentUser bbqcommentUser=new BbqcommentUser();

            // bbqcommentUser.setUser(restTemplate.getForObject(userUri, User.class,bbqcomment.getUserId()));
            User user = bbqServiceConsumer.getById(bbqcomment.getUserId());
            bbqcommentUser.setUser(user);

            bbqcommentUser.setBbqcommentDate(bbqcomment.getBbqcommentDate());
            bbqcommentUser.setBbqcommentId(bbqcomment.getBbqcommentId());
            bbqcommentUser.setBbqcommentLike(bbqcomment.getBbqcommentLike());
            bbqcommentUser.setBbqcommentMessage(bbqcomment.getBbqcommentMessage());
            bbqcommentUser.setBbqId(bbqcomment.getBbqId());
            list.add(bbqcommentUser);
        }
        return list;
    }

    public List<Bbqimage> getBbqImageListByBbqId(Integer bbqId) {
        Example example=new Example(Bbqimage.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("bbqId",bbqId);
        return bbqimageMapper.selectByExample(example);
    }

    @Override
    public BaseResult getABbqByBbqId(Integer bbqId) {
        BaseResult baseResult=new BaseResult();
        BbqUser bbqUser=new BbqUser();
        Bbq bbq = bbqMapper.selectByPrimaryKey(bbqId);
        List<Bbqimage> bbqImageListByBbqId = getBbqImageListByBbqId(bbq.getBbqId());
        bbqUser.setBbqDate(bbq.getBbqDate());
        bbqUser.setBbqId(bbq.getBbqId());
        bbqUser.setBbqLike(bbq.getBbqLike());
        bbqUser.setBbqMessage(bbq.getBbqMessage());
        bbqUser.setImages(bbqImageListByBbqId);
        bbqUser.setComments(getBbqCommentUserList(bbq.getBbqId()));
        baseResult.setStatus(200);
        baseResult.setO(bbqUser);
        return baseResult;
    }

    public List<BbqcommentUser> getBbqCommentUserList(Integer bbqId){
        RestTemplate restTemplate=new RestTemplate();
        Example example=new Example(Bbqcomment.class);
        example.setOrderByClause("bbqcomment_like desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bbqId",bbqId);
        List<Bbqcomment> bbqcomments = bbqcommentMapper.selectByExample(example);
        return getBbqcommentUsers(restTemplate, bbqcomments);
    }

    @Override
    public BaseResult addBbqLike(Integer bbqId) {
        BaseResult baseResult=new BaseResult();
        Bbq bbq = bbqMapper.selectByPrimaryKey(bbqId);
        bbq.setBbqLike(bbq.getBbqLike()+1);
        bbqMapper.updateByPrimaryKey(bbq);
        baseResult.setStatus(200);
        baseResult.setMessage("已经为他（她）加油！");
        return baseResult;
    }

    @Override
    public BaseResult addBbqCommentLike(Integer bbqcommentId) {
        BaseResult baseResult=new BaseResult();
        Bbqcomment bbqcomment = bbqcommentMapper.selectByPrimaryKey(bbqcommentId);
        bbqcomment.setBbqcommentLike(bbqcomment.getBbqcommentLike()+1);
        bbqcommentMapper.updateByPrimaryKey(bbqcomment);
        baseResult.setStatus(200);
        baseResult.setO(bbqcomment);
        return baseResult;
    }

    @Override
    public BaseResult addABbqCommentForBbqId(Integer bbqId,Integer userId,String bbqcommentMessage) {
        BaseResult baseResult=new BaseResult();
        Bbqcomment bbqcomment=new Bbqcomment();
        bbqcomment.setBbqcommentLike(0);
        bbqcomment.setBbqcommentDate(new Date());
        bbqcomment.setBbqcommentMessage(bbqcommentMessage);
        bbqcomment.setBbqId(bbqId);
        bbqcomment.setUserId(userId);
        bbqcommentMapper.insert(bbqcomment);
        Bbqcomment result = bbqcommentMapper.selectByPrimaryKey(bbqcomment.getBbqcommentId());
        RestTemplate restTemplate=new RestTemplate();
        BbqcommentUser bbqcommentUser=new BbqcommentUser();
        bbqcommentUser.setBbqcommentDate(result.getBbqcommentDate());
        bbqcommentUser.setBbqcommentId(result.getBbqcommentId());
        bbqcommentUser.setBbqcommentLike(result.getBbqcommentLike());
        bbqcommentUser.setBbqcommentMessage(result.getBbqcommentMessage());
        bbqcommentUser.setBbqId(result.getBbqId());

        //bbqcommentUser.setUser(restTemplate.getForObject(userUri,User.class,result.getUserId()));
        User user = bbqServiceConsumer.getById(result.getUserId());
        bbqcommentUser.setUser(user);

        baseResult.setStatus(200);
        return baseResult;
    }

    @Override
    public BaseResult addABbq(Integer userId, String bbqDetail) {
        BaseResult baseResult=new BaseResult();
        Bbq bbq = new Bbq();
        bbq.setBbqLike(0);
        bbq.setBbqDate(new Date());
        bbq.setBbqMessage(bbqDetail);
        bbq.setUserId(userId);
        bbqMapper.insert(bbq);
        baseResult.setStatus(200);
        baseResult.setO(bbq);
        return baseResult;
    }

    @Override
    public BaseResult addBbqImageForBbq(Integer bbqId, MultipartFile file) {
        BaseResult baseResult=new BaseResult();
        if (file!=null){
            Bbqimage bbqimage=new Bbqimage();
            try {
                //得到文件名
                String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')+1,
                        file.getOriginalFilename().length());
                //得到当前时间
                LocalDate date=LocalDate.now();
                //根据时间创建目录
                File targetpath=new File(UPLOAD_FOLDER+"\\bbqimg\\"+bbqId+"\\"+date);
                if (!targetpath.exists()){
                    targetpath.mkdirs();
                }
                String filename= UUID.randomUUID().toString().replaceAll("-","")+"."+suffix;
                file.transferTo(new File(targetpath,filename));
                bbqimage.setBbqId(bbqId);
                bbqimage.setBbqimageUrl("http://localhost:9833/img/bbqimg"+"/"+bbqId+"/"+date+"/"+filename);
                bbqimageMapper.insert(bbqimage);
                baseResult.setStatus(200);
                return baseResult;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        baseResult.setStatus(500);
        baseResult.setMessage("失败");
        return baseResult;
    }


}
