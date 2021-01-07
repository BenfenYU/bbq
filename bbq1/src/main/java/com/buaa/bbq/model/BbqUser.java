package com.buaa.bbq.model;

import java.util.Date;
import java.util.List;

public class BbqUser {
    private Integer bbqId;

    private String bbqMessage;

    private Date bbqDate;

    private User user;

    private Integer bbqLike;

    private List<Bbqimage> images;

    private List<BbqcommentUser> comments;

    @Override
    public String toString() {
        return "BbqUser{" +
                "bbqId=" + bbqId +
                ", bbqMessage='" + bbqMessage + '\'' +
                ", bbqDate=" + bbqDate +
                ", user=" + user +
                ", bbqLike=" + bbqLike +
                ", images=" + images +
                ", comments=" + comments +
                '}';
    }

    public List<BbqcommentUser> getComments() {
        return comments;
    }

    public void setComments(List<BbqcommentUser> comments) {
        this.comments = comments;
    }

    public BbqUser(Integer bbqId, String bbqMessage, Date bbqDate, User user, Integer bbqLike, List<Bbqimage> images, List<BbqcommentUser> comments) {
        this.bbqId = bbqId;
        this.bbqMessage = bbqMessage;
        this.bbqDate = bbqDate;
        this.user = user;
        this.bbqLike = bbqLike;
        this.images = images;
        this.comments = comments;
    }

    public BbqUser() {
    }

    public List<Bbqimage> getImages() {
        return images;
    }

    public void setImages(List<Bbqimage> images) {
        this.images = images;
    }

    public Integer getBbqId() {
        return bbqId;
    }

    public void setBbqId(Integer bbqId) {
        this.bbqId = bbqId;
    }

    public String getBbqMessage() {
        return bbqMessage;
    }

    public void setBbqMessage(String bbqMessage) {
        this.bbqMessage = bbqMessage;
    }

    public Date getBbqDate() {
        return bbqDate;
    }

    public void setBbqDate(Date bbqDate) {
        this.bbqDate = bbqDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getBbqLike() {
        return bbqLike;
    }

    public void setBbqLike(Integer bbqLike) {
        this.bbqLike = bbqLike;
    }
}
