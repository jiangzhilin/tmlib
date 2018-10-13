package com.liuge.TMShop.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

public class ShouyiEntity {

    /**
     * status : error
     * msg : 暂无数据
     * data : {"money":"0.00","result":[],"totalpage":0,"page":1,"wait":0,"ok":0}
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
         * money : 0.00
         * result : []
         * totalpage : 0
         * page : 1
         * wait : 0
         * ok : 0
         */

        private String money;
        private int totalpage;
        private int page;
        private int wait;
        private int ok;
        private List<?> result;

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getWait() {
            return wait;
        }

        public void setWait(int wait) {
            this.wait = wait;
        }

        public int getOk() {
            return ok;
        }

        public void setOk(int ok) {
            this.ok = ok;
        }

        public List<?> getResult() {
            return result;
        }

        public void setResult(List<?> result) {
            this.result = result;
        }
    }
}
