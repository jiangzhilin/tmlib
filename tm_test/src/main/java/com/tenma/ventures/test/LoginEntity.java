package com.tenma.ventures.test;

/**
 * Created by Administrator on 2018/11/9.
 */

public class LoginEntity {

    /**
     * code : 200
     * data : 登录信息
     * msg : 登录成功
     */

    private int code;
    private String data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
