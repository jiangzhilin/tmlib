package com.liuge.z02sckhd_6wqgx.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jiang on 2018/10/25.
 */

public class OrderWxPayEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"appid":"wx7ba7fbd409123407","noncestr":"nzB5ZHfRqUwg4WHW","package":"Sign=WXPay","partnerid":"1493222382","prepayid":"wx251722486866339ab000a89a0212813511","timestamp":1540459368,"sign":"B785B31021D91D49815097993F4FDE99"}
     */

    private String status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appid : wx7ba7fbd409123407
         * noncestr : nzB5ZHfRqUwg4WHW
         * package : Sign=WXPay
         * partnerid : 1493222382
         * prepayid : wx251722486866339ab000a89a0212813511
         * timestamp : 1540459368
         * sign : B785B31021D91D49815097993F4FDE99
         */

        private String appid;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private long timestamp;
        private String sign;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
