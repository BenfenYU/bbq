package com.example.oauth2client.common;

public class BaseResult {
    /*状态码*/
    private int status;

    /*返回信息*/
    private String message;

    /*携带数据*/
    private Object o;

    public BaseResult() {
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", o=" + o +
                '}';
    }

    public BaseResult(int status, String message, Object o) {
        this.status = status;
        this.message = message;
        this.o = o;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
}
