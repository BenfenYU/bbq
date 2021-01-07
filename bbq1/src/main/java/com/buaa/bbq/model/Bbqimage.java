package com.buaa.bbq.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "buaa.bbqimage")
public class Bbqimage {
    @Id
    @Column(name = "bbqimage_id")
    private Integer bbqimageId;

    @Column(name = "bbq_id")
    private Integer bbqId;

    @Column(name = "bbqimage_url")
    private String bbqimageUrl;

    /**
     * @return bbqimage_id
     */
    public Integer getBbqimageId() {
        return bbqimageId;
    }

    /**
     * @param bbqimageId
     */
    public void setBbqimageId(Integer bbqimageId) {
        this.bbqimageId = bbqimageId;
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

    /**
     * @return bbqimage_url
     */
    public String getBbqimageUrl() {
        return bbqimageUrl;
    }

    /**
     * @param bbqimageUrl
     */
    public void setBbqimageUrl(String bbqimageUrl) {
        this.bbqimageUrl = bbqimageUrl;
    }
}