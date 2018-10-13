package com.liuge.TMShop.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

public class CartEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"goods":[],"amount":0,"quantity":0}
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
         * goods : []
         * amount : 0
         * quantity : 0
         */

        private int amount;
        private int quantity;
        private List<?> goods;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public List<?> getGoods() {
            return goods;
        }

        public void setGoods(List<?> goods) {
            this.goods = goods;
        }
    }
}
