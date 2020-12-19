package com.buaa.message.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "buaa.messageimage")
public class Messageimage {
    @Id
    @Column(name = "messageimage_id")
    private Integer messageimageId;

    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "messageimage_url")
    private String messageimageUrl;

    /**
     * @return messageimage_id
     */
    public Integer getMessageimageId() {
        return messageimageId;
    }

    /**
     * @param messageimageId
     */
    public void setMessageimageId(Integer messageimageId) {
        this.messageimageId = messageimageId;
    }

    /**
     * @return message_id
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * @param messageId
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * @return messageimage_url
     */
    public String getMessageimageUrl() {
        return messageimageUrl;
    }

    /**
     * @param messageimageUrl
     */
    public void setMessageimageUrl(String messageimageUrl) {
        this.messageimageUrl = messageimageUrl;
    }
}