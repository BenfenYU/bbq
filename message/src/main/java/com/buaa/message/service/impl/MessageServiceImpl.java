package com.buaa.message.service.impl;

import com.buaa.message.common.BaseResult;
import com.buaa.message.mapper.MessageMapper;
import com.buaa.message.mapper.MessageimageMapper;
import com.buaa.message.model.Message;
import com.buaa.message.model.MessageUser;
import com.buaa.message.model.Messageimage;
import com.buaa.message.model.User;
import com.buaa.message.service.MessageConsumerService;
import com.buaa.message.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    // feign找服务
    @Autowired
    MessageConsumerService messageConsumerService;

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @Autowired
    private MessageimageMapper messageimageMapper;

    @Autowired
    private MessageMapper messageMapper;

    private final String userUri="http://localhost:9001/user/getById/{userId}";

    @Override
    public BaseResult getAllMessageOrderByDate(Integer offset, Integer limit) {
        RestTemplate restTemplate=new RestTemplate();
        BaseResult baseResult=new BaseResult();
        PageHelper.startPage(offset,limit);
        Example example=new Example(Message.class);
        example.setOrderByClause("message_date desc");
        List<Message> messages = messageMapper.selectByExample(example);
        PageInfo<Message> pageInfo=new PageInfo<>(messages);
        List<MessageUser> list=new ArrayList<>();
        for (Message message:pageInfo.getList()){
            MessageUser messageUser=new MessageUser();
            messageUser.setMessageDate(message.getMessageDate());
            messageUser.setMessageDetail(message.getMessageDetail());
            messageUser.setMessageId(message.getMessageId());
            messageUser.setImages(getMessageImages(messageUser.getMessageId()));

            // messageUser.setUser(restTemplate.getForObject(userUri, User.class,message.getUserId()));
            User user = messageConsumerService.getById(message.getUserId());
            messageUser.setUser(user);

            list.add(messageUser);
        }
        baseResult.setStatus((int) pageInfo.getTotal());
        baseResult.setO(list);
        return baseResult;
    }

    @Override
    public BaseResult getAMessageByMessageId(Integer messageId) {
        BaseResult baseResult=new BaseResult();
        Example example=new Example(Message.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("messageId",messageId);
        Message message = messageMapper.selectOneByExample(example);
        MessageUser messageUser=new MessageUser();
        messageUser.setMessageId(message.getMessageId());
        messageUser.setMessageDetail(message.getMessageDetail());
        messageUser.setMessageDate(message.getMessageDate());
        messageUser.setImages(getMessageImages(messageId));
        RestTemplate restTemplate=new RestTemplate();

        // messageUser.setUser(restTemplate.getForObject(userUri,User.class,message.getUserId()));
        User user = messageConsumerService.getById(message.getUserId());
        messageUser.setUser(user);

        baseResult.setO(messageUser);
        baseResult.setStatus(200);
        return baseResult;
    }

    @Override
    public BaseResult addAMessage(Integer userId, String messageDetail) {
        BaseResult baseResult=new BaseResult();
        Message message = new Message();
        message.setMessageDate(new Date());
        message.setMessageDetail(messageDetail);
        message.setUserId(userId);
        messageMapper.insert(message);
        baseResult.setStatus(200);
        baseResult.setO(message);
        return baseResult;
    }

    @Override
    public BaseResult addMessageImageForMessage(Integer messageId, MultipartFile file) {
        BaseResult baseResult=new BaseResult();
        if (file!=null){
            Messageimage messageimage=new Messageimage();
            try {
                //得到文件名
                String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')+1,
                        file.getOriginalFilename().length());
                //得到当前时间
                LocalDate date=LocalDate.now();
                //根据时间创建目录
                File targetpath=new File(UPLOAD_FOLDER+"\\messageimg\\"+messageId+"\\"+date);
                if (!targetpath.exists()){
                    targetpath.mkdirs();
                }
                String filename= UUID.randomUUID().toString().replaceAll("-","")+"."+suffix;
                file.transferTo(new File(targetpath,filename));
                messageimage.setMessageId(messageId);
                messageimage.setMessageimageUrl("http://localhost:9833/img/messageimg"+"/"+messageId+"/"+date+"/"+filename);
                messageimageMapper.insert(messageimage);
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

    public List<Messageimage> getMessageImages(Integer messageId){
        Example example=new Example(Messageimage.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("messageId",messageId);
        List<Messageimage> messageimages = messageimageMapper.selectByExample(example);
        return messageimages;
    }
}
