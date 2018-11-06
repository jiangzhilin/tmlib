package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

public class ShouyiEntity {


    /**
     * status : success
     * msg : 调用成功
     * data : {"money":"5,455.00","result":[{"id":"1387","order_id":"HT201811041210476","uid":"16","type":"2","price":"100.00","status":"0","alipay":"18482180351","bank":null,"content":"申请提现：100元.","balance":"5455.00","month":"201811","total":"0.00","add_time":"2018-11-04 12:10:47","sign":"-","edit_time":null,"way":"1","is_show":"0","exp_status":"0","exp_time":null,"form":"1"}],"totalpage":1,"page":1,"wait":100,"ok":0}
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
         * money : 5,455.00
         * result : [{"id":"1387","order_id":"HT201811041210476","uid":"16","type":"2","price":"100.00","status":"0","alipay":"18482180351","bank":null,"content":"申请提现：100元.","balance":"5455.00","month":"201811","total":"0.00","add_time":"2018-11-04 12:10:47","sign":"-","edit_time":null,"way":"1","is_show":"0","exp_status":"0","exp_time":null,"form":"1"}]
         * totalpage : 1
         * page : 1
         * wait : 100
         * ok : 0
         */

        private String money;
        private int totalpage;
        private int page;
        private int wait;
        private int ok;
        private List<ResultBean> result;

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

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * id : 1387
             * order_id : HT201811041210476
             * uid : 16
             * type : 2
             * price : 100.00
             * status : 0
             * alipay : 18482180351
             * bank : null
             * content : 申请提现：100元.
             * balance : 5455.00
             * month : 201811
             * total : 0.00
             * add_time : 2018-11-04 12:10:47
             * sign : -
             * edit_time : null
             * way : 1
             * is_show : 0
             * exp_status : 0
             * exp_time : null
             * form : 1
             */

            private String id;
            private String order_id;
            private String uid;
            private String type;
            private String price;
            private String status;
            private String alipay;
            private String bank;
            private String content;
            private String balance;
            private String month;
            private String total;
            private String add_time;
            private String sign;
            private Object edit_time;
            private String way;
            private String is_show;
            private String exp_status;
            private Object exp_time;
            private String form;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getAlipay() {
                return alipay;
            }

            public void setAlipay(String alipay) {
                this.alipay = alipay;
            }

            public String getBank() {
                return bank;
            }

            public void setBank(String bank) {
                this.bank = bank;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public Object getEdit_time() {
                return edit_time;
            }

            public void setEdit_time(Object edit_time) {
                this.edit_time = edit_time;
            }

            public String getWay() {
                return way;
            }

            public void setWay(String way) {
                this.way = way;
            }

            public String getIs_show() {
                return is_show;
            }

            public void setIs_show(String is_show) {
                this.is_show = is_show;
            }

            public String getExp_status() {
                return exp_status;
            }

            public void setExp_status(String exp_status) {
                this.exp_status = exp_status;
            }

            public Object getExp_time() {
                return exp_time;
            }

            public void setExp_time(Object exp_time) {
                this.exp_time = exp_time;
            }

            public String getForm() {
                return form;
            }

            public void setForm(String form) {
                this.form = form;
            }
        }
    }
}
