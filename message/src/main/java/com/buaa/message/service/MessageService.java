package com.buaa.message.service;

import com.buaa.message.common.BaseResult;
import org.springframework.web.multipart.MultipartFile;

public interface MessageService {

    BaseResult getAllMessageOrderByDate(Integer offset, Integer limit);

    BaseResult getAMessageByMessageId(Integer messageId);

    BaseResult addAMessage(Integer userId,String messageDetail);

    BaseResult addMessageImageForMessage(Integer messageId, MultipartFile file);
}
