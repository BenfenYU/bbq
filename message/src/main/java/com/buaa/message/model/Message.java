package com.buaa.message.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "buaa.message")
public class Message {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "message_detail")
    private String messageDetail;

    @Column(name = "message_date")
    private Date messageDate;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return message_detail
     */
    public String getMessageDetail() {
        return messageDetail;
    }

    /**
     * @param messageDetail
     */
    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    /**
     * @return message_date
     */
    public Date getMessageDate() {
        return messageDate;
    }

    /**
     * @param messageDate
     */
    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}