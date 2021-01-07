package com.buaa.bbq.model;

import java.util.Date;

public class BbqcommentUser {

    private Integer bbqcommentId;

    private User user;

    private Date bbqcommentDate;

    private String bbqcommentMessage;

    private Integer bbqcommentLike;

    private Integer bbqId;

    @Override
    public String toString() {
        return "BbqcommentUser{" +
                "bbqcommentId=" + bbqcommentId +
                ", user=" + user +
                ", bbqcommentDate=" + bbqcommentDate +
                ", bbqcommentMessage='" + bbqcommentMessage + '\'' +
                ", bbqcommentLike=" + bbqcommentLike +
                ", bbqId=" + bbqId +
                '}';
    }

    public Integer getBbqcommentId() {
        return bbqcommentId;
    }

    public void setBbqcommentId(Integer bbqcommentId) {
        this.bbqcommentId = bbqcommentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBbqcommentDate() {
        return bbqcommentDate;
    }

    public void setBbqcommentDate(Date bbqcommentDate) {
        this.bbqcommentDate = bbqcommentDate;
    }

    public String getBbqcommentMessage() {
        return bbqcommentMessage;
    }

    public void setBbqcommentMessage(String bbqcommentMessage) {
        this.bbqcommentMessage = bbqcommentMessage;
    }

    public Integer getBbqcommentLike() {
        return bbqcommentLike;
    }

    public void setBbqcommentLike(Integer bbqcommentLike) {
        this.bbqcommentLike = bbqcommentLike;
    }

    public Integer getBbqId() {
        return bbqId;
    }

    public void setBbqId(Integer bbqId) {
        this.bbqId = bbqId;
    }

    public BbqcommentUser() {
    }

    public BbqcommentUser(Integer bbqcommentId, User user, Date bbqcommentDate, String bbqcommentMessage, Integer bbqcommentLike, Integer bbqId) {
        this.bbqcommentId = bbqcommentId;
        this.user = user;
        this.bbqcommentDate = bbqcommentDate;
        this.bbqcommentMessage = bbqcommentMessage;
        this.bbqcommentLike = bbqcommentLike;
        this.bbqId = bbqId;
    }
}
