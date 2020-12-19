package com.buaa.bbq.model;

public class DataBean {
    private int noticeId;
    private String noticeTitle;
    private Object noticeImg;
    private long noticeCreateTime;
    private long noticeUpdateTime;
    private String noticeContent;

    @Override
    public String toString() {
        return "DataBean{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeImg=" + noticeImg +
                ", noticeCreateTime=" + noticeCreateTime +
                ", noticeUpdateTime=" + noticeUpdateTime +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}
