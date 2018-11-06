package com.liuge.z02sckhd_6wqgx.entity;

import java.util.List;

/**
 * Created by jiang on 2018/11/4.
 */

public class VipEntity {

    /**
     * status : success
     * msg : 获取成功
     * data : {"totalpage":1,"result":[{"user_id":"1","mobile":"13438885851","member_name":"如此尴尬。","add_time":"2018-08-02","head_pic":""},{"user_id":"2","mobile":"18880473227","member_name":"188****3227","add_time":"2018-08-02","head_pic":""}]}
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
         * totalpage : 1
         * result : [{"user_id":"1","mobile":"13438885851","member_name":"如此尴尬。","add_time":"2018-08-02","head_pic":""},{"user_id":"2","mobile":"18880473227","member_name":"188****3227","add_time":"2018-08-02","head_pic":""}]
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
             * user_id : 1
             * mobile : 13438885851
             * member_name : 如此尴尬。
             * add_time : 2018-08-02
             * head_pic :
             */

            private String user_id;
            private String mobile;
            private String member_name;
            private String add_time;
            private String head_pic;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getHead_pic() {
                return head_pic;
            }

            public void setHead_pic(String head_pic) {
                this.head_pic = head_pic;
            }
        }
    }
}
