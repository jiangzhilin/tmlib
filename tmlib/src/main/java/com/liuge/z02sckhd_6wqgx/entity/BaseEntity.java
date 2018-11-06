package com.liuge.z02sckhd_6wqgx.entity;

/**
 * Created by Administrator on 2018/9/18.
 */

public class BaseEntity {

    /**
     * status : success
     * msg  : 获取成功
     * data :
     */

    private String status;
    private String msg;
    private String data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
