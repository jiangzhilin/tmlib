package com.liuge.z02sckhd_6wqgx.entity;

/**
 * Created by jiang on 2018/11/4.
 */

public class UserEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"user_id":"16","mid":"55","user_money":"5455.00","frozen_money":"100.00","integral":"0","user_address":"104","add_time":"1540433398","pid":"0","code":"526867","tel":"134****5852"}
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
         * user_id : 16
         * mid : 55
         * user_money : 5455.00
         * frozen_money : 100.00
         * integral : 0
         * user_address : 104
         * add_time : 1540433398
         * pid : 0
         * code : 526867
         * tel : 134****5852
         */

        private String user_id;
        private String mid;
        private String user_money;
        private String frozen_money;
        private String integral;
        private String user_address;
        private String add_time;
        private String pid;
        private String code;
        private String tel;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getUser_money() {
            return user_money;
        }

        public void setUser_money(String user_money) {
            this.user_money = user_money;
        }

        public String getFrozen_money() {
            return frozen_money;
        }

        public void setFrozen_money(String frozen_money) {
            this.frozen_money = frozen_money;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getUser_address() {
            return user_address;
        }

        public void setUser_address(String user_address) {
            this.user_address = user_address;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
