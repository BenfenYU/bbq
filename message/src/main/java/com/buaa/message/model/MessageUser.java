package com.buaa.message.model;

import java.util.Date;
import java.util.List;

public class MessageUser {
    private Integer messageId;

    private User user;

    private String messageDetail;

    private Date messageDate;

    private List<Messageimage> images;

    @Override
    public String toString() {
        return "MessageUser{" +
                "messageId=" + messageId +
                ", user=" + user +
                ", messageDetail='" + messageDetail + '\'' +
                ", messageDate=" + messageDate +
                ", images=" + images +
                '}';
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public List<Messageimage> getImages() {
        return images;
    }

    public void setImages(List<Messageimage> images) {
        this.images = images;
    }

    public MessageUser() {
    }

    public MessageUser(Integer messageId, User user, String messageDetail, Date messageDate, List<Messageimage> images) {
        this.messageId = messageId;
        this.user = user;
        this.messageDetail = messageDetail;
        this.messageDate = messageDate;
        this.images = images;
    }
}
