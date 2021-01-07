package com.buaa.bbq.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "buaa.bbqcomment")
public class Bbqcomment {
    @Id
    @Column(name = "bbqcomment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bbqcommentId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "bbqcomment_date")
    private Date bbqcommentDate;

    @Column(name = "bbqcomment_message")
    private String bbqcommentMessage;

    @Column(name = "bbqcomment_like")
    private Integer bbqcommentLike;

    @Column(name = "bbq_id")
    private Integer bbqId;

    @Override
    public String toString() {
        return "Bbqcomment{" +
                "bbqcommentId=" + bbqcommentId +
                ", userId=" + userId +
                ", bbqcommentDate=" + bbqcommentDate +
                ", bbqcommentMessage='" + bbqcommentMessage + '\'' +
                ", bbqcommentLike=" + bbqcommentLike +
                ", bbqId=" + bbqId +
                '}';
    }

    /**
     * @return bbqcomment_id
     */
    public Integer getBbqcommentId() {
        return bbqcommentId;
    }

    /**
     * @param bbqcommentId
     */
    public void setBbqcommentId(Integer bbqcommentId) {
        this.bbqcommentId = bbqcommentId;
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
     * @return bbqcomment_date
     */
    public Date getBbqcommentDate() {
        return bbqcommentDate;
    }

    /**
     * @param bbqcommentDate
     */
    public void setBbqcommentDate(Date bbqcommentDate) {
        this.bbqcommentDate = bbqcommentDate;
    }

    /**
     * @return bbqcomment_message
     */
    public String getBbqcommentMessage() {
        return bbqcommentMessage;
    }

    /**
     * @param bbqcommentMessage
     */
    public void setBbqcommentMessage(String bbqcommentMessage) {
        this.bbqcommentMessage = bbqcommentMessage;
    }

    /**
     * @return bbqcomment_like
     */
    public Integer getBbqcommentLike() {
        return bbqcommentLike;
    }

    /**
     * @param bbqcommentLike
     */
    public void setBbqcommentLike(Integer bbqcommentLike) {
        this.bbqcommentLike = bbqcommentLike;
    }

    /**
     * @return bbq_id
     */
    public Integer getBbqId() {
        return bbqId;
    }

    /**
     * @param bbqId
     */
    public void setBbqId(Integer bbqId) {
        this.bbqId = bbqId;
    }
}