package com.buaa.bbq.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "buaa.bbq")
public class Bbq {
    @Id
    @Column(name = "bbq_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bbqId;

    @Column(name = "bbq_message")
    private String bbqMessage;

    @Column(name = "bbq_date")
    private Date bbqDate;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "bbq_like")
    private Integer bbqLike;

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

    /**
     * @return bbq_message
     */
    public String getBbqMessage() {
        return bbqMessage;
    }

    /**
     * @param bbqMessage
     */
    public void setBbqMessage(String bbqMessage) {
        this.bbqMessage = bbqMessage;
    }

    /**
     * @return bbq_date
     */
    public Date getBbqDate() {
        return bbqDate;
    }

    /**
     * @param bbqDate
     */
    public void setBbqDate(Date bbqDate) {
        this.bbqDate = bbqDate;
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
     * @return bbq_like
     */
    public Integer getBbqLike() {
        return bbqLike;
    }

    /**
     * @param bbqLike
     */
    public void setBbqLike(Integer bbqLike) {
        this.bbqLike = bbqLike;
    }
}