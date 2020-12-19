package com.buaa.bbq.model;

import java.util.List;

public class Notice {
    private int status;
    private Object msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "Notice{" +
                "status=" + status +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }
}
