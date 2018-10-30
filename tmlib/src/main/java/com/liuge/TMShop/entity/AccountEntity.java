package com.liuge.TMShop.entity;

import java.util.List;

/**
 * Created by jiang on 2018/10/28.
 */

public class AccountEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"result":[{"id":"28","user_id":"16","form":"1","type":"1","number":"18482180351","is_default":"0","add_time":"1540717747"}],"totalpage":1}
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
         * result : [{"id":"28","user_id":"16","form":"1","type":"1","number":"18482180351","is_default":"0","add_time":"1540717747"}]
         * totalpage : 1
         */

        private int totalpage;
        private List<ResultBean> result;

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * id : 28
             * user_id : 16
             * form : 1
             * type : 1
             * number : 18482180351
             * is_default : 0
             * add_time : 1540717747
             */

            private String id;
            private String user_id;
            private String form;
            private String type;
            private String number;
            private String is_default;
            private String add_time;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getForm() {
                return form;
            }

            public void setForm(String form) {
                this.form = form;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }
        }
    }
}
