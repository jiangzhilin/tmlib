package com.liuge.z02sckhd_6wqgx.entity;

/**
 * Created by jiang on 2018/10/25.
 */

public class CreateOrderResultEntity {


    /**
     * status : success
     * msg : 下单成功
     * data : {"mid":"94","order_id":"94","order_sn":"2018102570924"}
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
         * mid : 94
         * order_id : 94
         * order_sn : 2018102570924
         */

        private String mid;
        private String order_id;
        private String order_sn;

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }
    }
}
